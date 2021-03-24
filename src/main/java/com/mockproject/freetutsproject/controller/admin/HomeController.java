package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.*;
import com.mockproject.freetutsproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller (value = "homeOfAdmin")
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/admin")
    public String loginPage() {
        // Validated that user logined
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/admin/panel";
    }

    @GetMapping (value = "/admin/panel")
    public String loadMenu(Model model) {
        model.addAttribute("POST_DTO",new PostDTO());
        model.addAttribute("COURSE_DTO",new CourseDTO());
        model.addAttribute("DISCOUNT",new DiscountDTO());
        model.addAttribute("ADMIN_DTO",new AdminDTO());
        model.addAttribute("CATEGORY_DTO",new CategoryDTO());
        model.addAttribute("CATEGORIES", categoryService.findBySubCategoriesIsNull());
        model.addAttribute("ALL_CATEGORIES", sortAsRelationship(categoryService.loadTopLevelCategories()));
        model.addAttribute("COURSE_CATEGORIES", categoryService.findCategory("Khóa học").getSubCategories());

        return "template-admin-page";
    }

    private List<CategoryDTO> sortAsRelationship(List<CategoryDTO> topLevelCategory){
        List<CategoryDTO> result = new ArrayList<>();
        for (CategoryDTO categoryDTO : topLevelCategory) {
            result.add(categoryDTO);
            List<CategoryDTO> subCate = categoryDTO.getSubCategories();
            if (!subCate.isEmpty()) {
                // Recursive with sub category list of categoryDTO
                result.addAll(sortAsRelationship(subCate));
            }
        }
        return result;
    }
}
