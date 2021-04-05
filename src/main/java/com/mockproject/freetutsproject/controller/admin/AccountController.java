package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.AdminDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/account")
    public String createAccount(AdminDTO adminDTO){
        if (!adminService.checkUsernameExist(adminDTO.getUsername())){
            adminService.save(adminDTO);
            return "redirect:/admin/account?success";
        }
        return "redirect:/admin/account?error";
    }

    @GetMapping(value = "/admin/account")
    public String loadAccount(Model model) {
        List<AdminDTO> accounts = adminService.findAll();
        model.addAttribute("accounts", accounts);
        model.addAttribute("ADMIN_DTO",new AdminDTO());
        
        return "admin/admin-account";
    }
}
