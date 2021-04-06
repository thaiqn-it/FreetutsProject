package com.mockproject.freetutsproject.controller.admin;

import java.util.List;

import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.service.DiscountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping("/admin/discount")
    @ResponseBody
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        if (!discountService.checkCodeExist(discountDTO.getDiscountCode())) {
            return discountService.save(discountDTO);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existed discount code");
        }
    }

    @GetMapping(value = "/admin/discount")
    public String loadAdminDiscount(Model model) {
        List<DiscountDTO> discounts = discountService.findAll();
        model.addAttribute("DISCOUNT", new DiscountDTO());
        model.addAttribute("DISCOUNTS", discounts);

        model.addAttribute("AVAILABLE", countAvailable(discounts));
        return "admin/admin-discount";
    }

    @GetMapping(value = "/admin/discount/{id}/{status}")
    public String updateDiscountStatus(@PathVariable("status") boolean status, @PathVariable("id") String id) {
        DiscountDTO result = discountService.updateStatus(status, Long.parseLong(id));
        if (result != null)
            return "redirect:/admin/discount?success";
        return "redirect:/admin/discount?error";

    }

    @PostMapping(value = "/admin/discount/update")
    public String editDiscount(DiscountDTO dto) {
        DiscountDTO result = discountService.updateDiscount(dto);
        if (result != null)
            return "redirect:/admin/discount?success";
        return "redirect:/admin/discount?error";
    }

    private long countAvailable(List<DiscountDTO> discounts) {
        return discounts.stream().filter(discount -> discount.isAvailable()).count();
    }
}
