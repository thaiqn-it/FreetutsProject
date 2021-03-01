package com.mockproject.freetutsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping (value = "/testabc", method = RequestMethod.GET)
	public String loadMenu() {
		return "test";
	}
	
}
