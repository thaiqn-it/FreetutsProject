package com.mockproject.freetutsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
	
	//demo
	@RequestMapping (value = "/demo-post", method = RequestMethod.GET)
	public String loadDemoPost() {
		return "demo-post";
	}
	
	/* not yet
	 * 
	@RequestMapping (value = "/{Post.name}", method = RequestMethod.GET)
	public String loadPost() {
		return "";
	}
	*/
}
