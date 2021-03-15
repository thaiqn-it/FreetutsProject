package com.mockproject.freetutsproject.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FooterController {

    @GetMapping("/lien-he/{name}")
    public String loadFooter(@PathVariable("name") String name) {
        System.out.println(name);
        return name;
    }
}
