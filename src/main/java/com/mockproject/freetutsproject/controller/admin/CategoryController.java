package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/admin/category")
    public String createCategory(CategoryDTO categoryDTO){
        if (categoryService.findCategory(categoryDTO.getName()) == null){
            categoryService.save(categoryDTO);
            return "redirect:/admin/panel/?success";
        }
        return "redirect:/admin/panel/?error";
    }
}
