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

import java.util.ArrayList;
import java.util.List;

@Controller(value ="webCourse")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MultiLevelCategoryUtil categoryUtil;

    @GetMapping(value = "/course/{id}")
    public String viewCourse(@PathVariable("id") String id, Model model) {
        CourseDTO dto = courseService.findById(Long.parseLong(id));

        if (dto != null) {
            model.addAttribute("course", dto);
            setOtherDataOfPostPage(dto, model);
        }
        return "web/course";
    }

    private void setOtherDataOfPostPage(CourseDTO dto, Model model){
        // Get breadcrumb data
        model.addAttribute("BREADCRUMB", loadCategoryBreadcrumb(dto));

        // Comment object for comment form
        model.addAttribute("COMMENT", loadCommentDTO(dto.getId()));

        // Load order dto
        model.addAttribute("ORDER", loadOrderDTO(dto.getId(), dto.getPrice()));
    }

    private CommentDTO loadCommentDTO(long courseId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCourseId(courseId);
        return commentDTO;
    }

    private OrderDTO loadOrderDTO(long courseId, float price) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCourseIds(new ArrayList<>());
        orderDTO.getCourseIds().add(courseId);
        orderDTO.setPrice(price);
        return orderDTO;
    }

    private List<CategoryDTO> loadCategoryBreadcrumb(CourseDTO dto){
        long categoryId = dto.getCategoryId();
        CategoryDTO category = categoryService.findById(categoryId);
        return categoryUtil.getCategoryListBottomUp(category);
    }
}
