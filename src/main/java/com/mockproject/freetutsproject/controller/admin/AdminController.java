package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CourseService courseService;
	
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
    	List<CourseDTO> courses = courseService.findAll();
    	model.addAttribute("courses", courses);
        return "admin/admin-course";
    }
    
    //UpdateStatus
    @GetMapping (value = "/admin/category/update-status:{status}/{id}")
    public String updateCategoryStatus(@PathVariable("status") boolean status, 
    							@PathVariable("id") Long id) {
    	CategoryDTO dto = categoryService.findById(id);
    	categoryService.updateStatus(status, dto);
        return "redirect:/admin/category";
    }
    
    @GetMapping (value = "/admin/post/update-status:{status}/{id}")
    public String updatePostStatus(@PathVariable("status") boolean status, 
    							@PathVariable("id") Long id) {
    	PostDTO dto = postService.findById(id);
    	postService.updateStatus(status, dto);
        return "redirect:/admin/post";
    }
    
    @GetMapping (value = "/admin/course/update-status:{status}/{id}")
    public String updateCourseStatus(@PathVariable("status") boolean status, 
    							@PathVariable("id") Long id) {
    	CourseDTO dto = courseService.findById(id);
    	courseService.updateStatus(status, dto);
        return "redirect:/admin/course";
    }
    //.UpdateStatus
    
    @GetMapping (value = "/admin/panel")
    public String loadAdminCreatePost() {
        return "admin-new-post";
    }
    
}
