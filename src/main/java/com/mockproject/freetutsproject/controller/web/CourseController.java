package com.mockproject.freetutsproject.controller.web;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MultiLevelCategoryUtil categoryUtil;

    @GetMapping(value = "/course/{id}")
    public String viewCourse(@PathVariable("id") String id, Model model) {
        CourseDTO dto = courseService.findCourseById(Long.parseLong(id));
        model.addAttribute("course", dto);

        if (dto != null) {
            long categoryId = dto.getCategoryId();
            CategoryDTO category = categoryService.findCategory(categoryId);

            // Get breadcrumb data
            List<CategoryDTO> categoryBreadcrumb = categoryUtil.getCategoryListBottomUp(category);
            model.addAttribute("breadcrumb", categoryBreadcrumb);

            // Comment object for comment form
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setCourseId(Long.parseLong(id));
            model.addAttribute("comment", commentDTO);

            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCourseId(Long.parseLong(id));
            orderDTO.setPrice(dto.getPrice());
            model.addAttribute("order", orderDTO);
        }
        return "course";
    }
}
