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
            return "redirect:/admin/panel/?success";
        }
        return "redirect:/admin/panel/?error";
    }

    @GetMapping(value = "/admin/category/{id}/{status}")
    public String updateCategoryStatus(@PathVariable("status") boolean status,
                                       @PathVariable("id") Long id) {
        CategoryDTO dto = categoryService.findById(id);
        categoryService.updateStatus(status, dto);
        if (!status) {
            updateChildrenStatus(status, dto);
            updatePostsStatus(status, dto);
            updateCoursesStatus(status, dto);
        }
        else {
            if (dto.getParentId() != null) {
                updateParent(status, dto);
            }
            updatePostsStatus(status, dto);
            updateCoursesStatus(status, dto);
        }
        return "redirect:/admin/category";
    }

    @GetMapping (value = "/admin/category")
    public String loadAdminCategory(Model model) {
        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/admin-category";
    }

    private void updateChildrenStatus(boolean status, CategoryDTO dto){
        List<CategoryDTO> children = categoryService.findByParentId(dto.getId());
        if (children != null){
            children.forEach(child -> {
                categoryService.updateStatus(status, child);
                updatePostsStatus(status, child);
                updateCoursesStatus(status, child);

                if (child.getSubCategories() != null){
                    updateChildrenStatus(status, child);
                }
            });
        }
    }

    private void updatePostsStatus(boolean status, CategoryDTO dto){
        List<PostDTO> posts = postService.findPostByCategory(dto);
        if (posts != null){
            posts.forEach(post -> postService.updateStatus(status, post));
        }
    }

    private void updateCoursesStatus(boolean status, CategoryDTO dto){
        List<CourseDTO> courses = courseService.findCoursesByCategory(dto);
        if (courses != null){
            courses.forEach(course -> courseService.updateStatus(status, course));
        }
    }

    private void updateParent(boolean status, CategoryDTO categoryDTO){
        CategoryDTO parent = categoryService.findById(categoryDTO.getParentId());
        if (parent != null){
            categoryService.updateStatus(status, parent);
            updateCoursesStatus(status, parent);
            updatePostsStatus(status, parent);

            if (parent.getParentId() != null){
                updateParent(status, parent);
            }
        }
    }
}
