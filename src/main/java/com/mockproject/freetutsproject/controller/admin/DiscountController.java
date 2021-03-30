package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.swing.*;
import java.util.List;

@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping("/admin/discount")
     public String createDiscount(DiscountDTO discountDTO){
        if (!discountService.checkCodeExist(discountDTO.getDiscountCode())){
            discountService.save(discountDTO);
            return "redirect:/admin/discount?success";
        }
        return "redirect:/admin/discount?error";
    }

    @GetMapping (value = "/admin/discount")
    public String loadAdminDiscount(Model model) {
        List<DiscountDTO> discount = discountService.findAll();
        model.addAttribute("DISCOUNT",new DiscountDTO());
        model.addAttribute("discount",discount);

        return "admin/admin-discount";
    }

    @GetMapping(value = "/admin/discount/{id}/{status}")
    public String updateDiscountStatus(@PathVariable("status") boolean status,
                                     @PathVariable("id") String id) {
        DiscountDTO result = discountService.updateStatus(status, Long.parseLong(id));
        if (result != null) return "redirect:/admin/discount?success";
        return "redirect:/admin/discount?error";

    }

    @PostMapping(value = "/admin/discount/update")
    public String editDiscount(DiscountDTO dto){
        DiscountDTO result = discountService.updateDiscount(dto);
        if(result != null) return "redirect:/admin/discount?success";
        return "redirect:/admin/discount?error";
    }
}
