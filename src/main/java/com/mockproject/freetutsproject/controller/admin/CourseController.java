package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CourseDTO;
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

    @PostMapping("/admin/course")
    public String createCourse(CourseDTO courseDTO){
        courseService.save(courseDTO);
        return "redirect:/admin/panel/?success";
    }

    @GetMapping(value = "/admin/course/{id}/{status}")
    public String updateCourseStatus(@PathVariable("status") boolean status,
                                     @PathVariable("id") Long id) {
        CourseDTO dto = courseService.findById(id);
        courseService.updateStatus(status, dto);
        return "redirect:/admin/course";
    }

    @GetMapping (value = "/admin/course")
    public String loadAdminCourse(Model model) {
        List<CourseDTO> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "admin/admin-course";
    }
}
