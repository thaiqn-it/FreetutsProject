package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller (value = "categoryControllerOfAdmin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/admin/category")
    public String createCategory(CategoryDTO categoryDTO){
        if (categoryService.findCategory(categoryDTO.getName()) == null){
            categoryService.save(categoryDTO);
            return "redirect:/admin/category?success";
        }
        return "redirect:/admin/category?error";
    }

    @GetMapping(value = { "/admin/category/{id}/{status}", "/admin/category/{id}/{status}/{enableChildren}"})
    public String updateCategoryStatus(@PathVariable("status") boolean status,
                                       @PathVariable("id") Long id,
                                       @PathVariable(value = "enableChildren", required = false) String enableString) {
        CategoryDTO result = categoryService.updateStatus(status, id);
        boolean success = result != null;
        if (success) {
            boolean enableChildren = enableString != null;
            updateRelateItems(status, id, enableChildren);
            return "redirect:/admin/category?success";
        }
        return "redirect:/admin/category?error";
    }

    @GetMapping (value = "/admin/category")
    public String loadAdminCategory(Model model) {
        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("CATEGORY_DTO",new CategoryDTO());
        model.addAttribute("ALL_CATEGORIES", sortAsRelationship(categoryService.loadTopLevelCategories()));

        return "admin/admin-category";
    }


    @PostMapping("/admin/category/update")
    public String updateCategory(CategoryDTO dto) {
        CategoryDTO result = null;
        try {
            result = categoryService.updateCategory(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result != null) return "redirect:/admin/category?success";
        return "redirect:/admin/category?error";
    }

    private List<CategoryDTO> sortAsRelationship(List<CategoryDTO> topLevelCategories){
        List<CategoryDTO> result = new ArrayList<>();
        for (CategoryDTO categoryDTO : topLevelCategories) {
            result.add(categoryDTO);
            List<CategoryDTO> subCate = categoryDTO.getSubCategories();
            if (!subCate.isEmpty()) {
                // Recursive with sub category list of categoryDTO
                result.addAll(sortAsRelationship(subCate));
            }
        }
        return result;
    }

    private void updateChildrenStatus(boolean status, CategoryDTO dto){
        List<CategoryDTO> children = categoryService.findByParentId(dto.getId());
        if (children != null){
            children.forEach(child -> {
                categoryService.updateStatus(status, child.getId());
                updatePostsStatus(status, child);
                updateCoursesStatus(status, child);

                if (child.getSubCategories() != null){
                    updateChildrenStatus(status, child);
                }
            });
        }
    }

    private void updateRelateItems(boolean status, long id, boolean enableChildren){
        CategoryDTO dto = categoryService.findById(id);
        if (!status) {
            updateChildrenStatus(status, dto);
        } else {
            if (dto.getParentId() != null) {
                updateParent(status, dto);
            }
            if (enableChildren){
                updateChildrenStatus(status, dto);
            }
        }
        updatePostsStatus(status, dto);
        updateCoursesStatus(status, dto);
    }

    private void updatePostsStatus(boolean status, CategoryDTO dto){
        List<PostDTO> posts = postService.findPostByCategory(dto);
        if (posts != null){
            posts.forEach(post -> postService.updateStatus(status, post.getId()));
        }
    }

    private void updateCoursesStatus(boolean status, CategoryDTO dto){
        List<CourseDTO> courses = courseService.findCoursesByCategory(dto);
        if (courses != null){
            courses.forEach(course -> courseService.updateStatus(status, course.getId()));
        }
    }

    private void updateParent(boolean status, CategoryDTO categoryDTO){
        CategoryDTO parent = categoryService.findById(categoryDTO.getParentId());
        if (parent != null){
            categoryService.updateStatus(status, parent.getId());
            updateCoursesStatus(status, parent);
            updatePostsStatus(status, parent);

            if (parent.getParentId() != null){
                updateParent(status, parent);
            }
        }
    }
}
