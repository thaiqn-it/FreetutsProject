package com.mockproject.freetutsproject.controller.admin;

import java.util.List;

import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.service.OrderService;
import com.mockproject.freetutsproject.util.CountUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller(value = "orderControllerOfAdmin")
public class OrderController {

    @Autowired
    private CountUtil<OrderDTO> countUtil;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/admin/order")
    public String loadAdminDiscount(Model model) {
        List<OrderDTO> orders = orderService.findAll();
        model.addAttribute("ORDER_DTO", new DiscountDTO());
        model.addAttribute("ORDERS", orders);

        model.addAttribute("AVAILABLE", countUtil.countAvailable(orders));

        return "admin/admin-order";
    }

    @GetMapping(value = "/admin/order/{id}/{status}")
    public String updateCourseStatus(@PathVariable("status") boolean status,
                                     @PathVariable("id") Long id) {
        OrderDTO result = orderService.updateStatus(status, id);
        if (result != null) return "redirect:/admin/order?success";
        return "redirect:/admin/order?error";
    }
}
