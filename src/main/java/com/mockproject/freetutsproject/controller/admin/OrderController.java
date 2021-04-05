package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller(value = "orderControllerOfAdmin")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/admin/order")
    public String loadAdminDiscount(Model model) {
        List<OrderDTO> order = orderService.findAll();
        model.addAttribute("ORDER_DTO",new DiscountDTO());
        model.addAttribute("orders",order);

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
