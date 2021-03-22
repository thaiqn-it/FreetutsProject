package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping("/admin/discount")
     public String createDiscount(DiscountDTO discountDTO){
        discountService.save(discountDTO);
        return "redirect:/admin/panel/?success";
    }
}
