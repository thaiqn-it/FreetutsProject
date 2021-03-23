package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.AdminDTO;
import com.mockproject.freetutsproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/account")
    public String createAccount(AdminDTO adminDTO){
        if (!adminService.checkUsernameExist(adminDTO.getUsername())){
            adminService.save(adminDTO);
            return "redirect:/admin/panel/?success";
        }
        return "redirect:/admin/panel/?error";
    }
}
