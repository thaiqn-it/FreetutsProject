package com.mockproject.freetutsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	@RequestMapping(value = "post/{name}", method = RequestMethod.GET)
	public String loadPost(@PathVariable("name") String name, Model model) {
		PostDTO post_dto = this.postService.loadPostInfo(name);

		model.addAttribute("post", post_dto);
		return "demo-post";
	}

}
