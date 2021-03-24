package com.mockproject.freetutsproject.controller.web;

import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order")
    public String saveOrder(OrderDTO orderDTO){
        // calc price
        int method = Integer.parseInt(orderDTO.getPaymentMethod().toString());
        switch (method) {
            case 2 :
                orderDTO.setPrice(orderDTO.getPrice() + 25000);
                break;
            case 3 :
                orderDTO.setPrice(orderDTO.getPrice() / 23000);
                break;
        }
        orderService.save(orderDTO);

        return "redirect:web/course/" + orderDTO.getCourseId() + "?success";
    }
}
