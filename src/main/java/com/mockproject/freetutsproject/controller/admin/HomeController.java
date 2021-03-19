package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

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
        PostDTO postDTO = new PostDTO();

        model.addAttribute("POST_DTO",postDTO);
        model.addAttribute("CATEGORIES", categoryService.findBySubCategoriesIsNull());

        return "template-admin-page";
    }
}
