package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.*;
import com.mockproject.freetutsproject.service.AdminService;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.service.DiscountService;
import com.mockproject.freetutsproject.service.OrderService;
import com.mockproject.freetutsproject.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller(value = "homeOfAdmin")
public class HomeController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;

	@Autowired
	CourseService courseService;

	@Autowired
	DiscountService discountService;

	@Autowired
	AdminService adminService;

	@Autowired
	OrderService orderService;

	@GetMapping(value = "/admin")
	public String loginPage() {
		// Validated that user logined
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}

		return "redirect:/admin/panel";
	}

	@GetMapping(value = "/admin/panel")
	public String loadMenu(Model model) {

		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("CATEGORIES", categories);

		List<PostDTO> posts = postService.findAll();
		model.addAttribute("POSTS", posts);

		List<CourseDTO> courses = courseService.findAll();
		model.addAttribute("COURSES", courses);
		
		List<DiscountDTO> discount = discountService.findAll();
		model.addAttribute("DISCOUNTS", discount);
		
		List<AdminDTO> accounts = adminService.findAll();
		model.addAttribute("ACCOUNTS", accounts);
		
		List<OrderDTO> orders = orderService.findAll();
		model.addAttribute("ORDERS", orders);

		return "/admin/panel";
	}

}
