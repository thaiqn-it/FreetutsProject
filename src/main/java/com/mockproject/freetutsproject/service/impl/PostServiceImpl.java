package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.PostRepository;
import com.mockproject.freetutsproject.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
}
