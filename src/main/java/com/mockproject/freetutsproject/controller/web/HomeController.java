package com.mockproject.freetutsproject.controller.web;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;

    @GetMapping(value = "/")
    public String loadHome(Model model){
        // Load widget review course
        CategoryDTO category = categoryService.findCategory((long)34);
        List<PostDTO> postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("COURSE_REVIEW",postList);

        // load post lap trinh
        category = categoryService.findCategory((long)1);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("LAPTRINH",postList);

        //load post quản trị web
        category = categoryService.findCategory((long)42);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("WEBSITE",postList);

        //load post tin học
        category = categoryService.findCategory((long)16);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("TINHOC",postList);

        //load thủ thuật
        category = categoryService.findCategory((long)47);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("THUTHUAT",postList);

        //load doawnload
        category = categoryService.findCategory((long)50);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("DOWNLOAD",postList);

        //load marketing
        category = categoryService.findCategory((long)58);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("MARKETING",postList);

        //load khám phá
        category = categoryService.findCategory((long)61);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("KHAMPHA",postList);

        //load môn học
        category = categoryService.findCategory((long)54);
        postList = postService.findPostByCategoryAndOrderedByIdLimitedTo(category,5);
        model.addAttribute("MONHOC",postList);

        return "home";
    }
}
