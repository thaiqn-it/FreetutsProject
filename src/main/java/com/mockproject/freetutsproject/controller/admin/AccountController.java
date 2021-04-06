package com.mockproject.freetutsproject.controller.admin;

import java.util.List;

import com.mockproject.freetutsproject.dto.AdminDTO;
import com.mockproject.freetutsproject.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/admin/change")
    public String changeInfo(AdminDTO adminDTO){
        if (adminService.checkUsernameExist(adminDTO.getUsername())){
            if (adminService.checkPasswordValid(adminDTO)){
                adminService.save(adminDTO);
                return "redirect:/admin/" + adminDTO.getId() + "?success";
            }
        }
        return "redirect:/admin/" + adminDTO.getId() +  "?error";
    }

    @GetMapping(value = "/admin/account")
    public String loadAccount(Model model) {
        List<AdminDTO> accounts = adminService.findAll();
        model.addAttribute("ACCOUNTS", accounts);
        model.addAttribute("ADMIN_DTO",new AdminDTO());
        
        return "admin/admin-account";
    }

    @GetMapping(value= "admin/{id}")
    public String loadInfo(Model model , @PathVariable("id") Long id){
        AdminDTO admin = adminService.findById(id);
        model.addAttribute("ADMIN_DTO",admin);
        return "admin/admin-info";
    }
}
