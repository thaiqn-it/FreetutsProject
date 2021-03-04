package com.mockproject.freetutsproject.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.service.CategoryService;

@Controller
public class WebController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping (value = "/category/{id}")
	public String viewCategory(@PathVariable("id") String id, Model model) {
		CategoryDTO dto = categoryService.findCategory(Long.parseLong(id));
		
		model.addAttribute("category", dto);
		return "category";
	}
}
