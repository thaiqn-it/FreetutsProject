package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping(value = "/admin/category/update-status:{status}/{id}")
    public String updateCategoryStatus(@PathVariable("status") boolean status,
                                       @PathVariable("id") Long id) {
        CategoryDTO dto = categoryService.findById(id);
        categoryService.updateStatus(status, dto);
        return "redirect:/admin/category";
    }

    @GetMapping (value = "/admin/category")
    public String loadAdminCategory(Model model) {
        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/admin-category";
    }
}
