package com.mockproject.freetutsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mockproject.freetutsproject.entity.ContentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.repository.ContentRepository;
import com.mockproject.freetutsproject.repository.PostRepository;

@Controller
public class PostController {
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	ContentRepository contentRepository;
	/*
	@RequestMapping (value = "/demo-post", method = RequestMethod.GET)
	public String loadDemoPost() {
		return "demo-post";
	}
	*/

	@RequestMapping (value = "post/{name}", method = RequestMethod.GET)
	public String loadPost(@PathVariable("name") String name, Model model) {
		PostEntity post = this.postRepository.findByName(name);
		List<ContentEntity> contents = this.contentRepository.findByPost(post);
		
		model.addAttribute("post", post);
		model.addAttribute("contents", contents);
		return "demo-post";
	}

}
