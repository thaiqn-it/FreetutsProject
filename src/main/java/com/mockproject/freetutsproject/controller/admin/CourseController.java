package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller(value ="adminCourse")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/admin/course")
    public String createCourse(CourseDTO courseDTO){
        courseService.save(courseDTO);
        return "redirect:/admin/panel/?success";
    }
}
