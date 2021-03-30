package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller(value ="adminCourse")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("/admin/course")
    public String createCourse(CourseDTO courseDTO){
        CourseDTO result = courseService.save(courseDTO);
        if (result != null) return "redirect:/admin/course?success";
        return "redirect:/admin/course?error";
    }

    @GetMapping(value = "/admin/course/{id}/{status}")
    public String updateCourseStatus(@PathVariable("status") boolean status,
                                     @PathVariable("id") Long id) {
        CourseDTO result = courseService.updateStatus(status, id);
        if (result != null) return "redirect:/admin/course?success";
        return "redirect:/admin/course?error";
    }

    @GetMapping (value = "/admin/course")
    public String loadAdminCourse(Model model) {
        List<CourseDTO> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("COURSE_DTO",new CourseDTO());
        model.addAttribute("COURSE_CATEGORIES", categoryService.findCategory("Khóa học").getSubCategories());
        return "admin/admin-course";
    }
}
