package com.mockproject.freetutsproject.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.PostService;

@Controller
public class AdminController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
    @GetMapping(value = "/admin")
    public String loginPage() {
        // Validated that user logined
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/admin/home";
    }
    
    @GetMapping (value = "/admin/home")
    public String loadMenu() {
        return "admin/template-admin-page";
    }
    
    @GetMapping (value = "/admin/category")
    public String loadAdminCategory(Model model) {
    	List<CategoryDTO> categories = categoryService.findAll();
    	model.addAttribute("categories", categories);
        return "admin/admin-category";
    }
    
    @GetMapping (value = "/admin/post")
    public String loadAdminPost(Model model) {
    	List<PostDTO> posts = postService.findAll();
    	
    	model.addAttribute("posts", posts);
        return "admin/admin-post";
    }
    
    @GetMapping (value = "/admin/course")
    public String loadAdminCourse(Model model) {

        return "admin/admin-course";
    }
    
    
    @GetMapping (value = "/admin/panel")
    public String loadAdminCreatePost() {
        return "admin-new-post";
    }
    
}
