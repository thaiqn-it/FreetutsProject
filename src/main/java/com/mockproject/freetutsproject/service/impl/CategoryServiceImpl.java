package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.CategoryRepository;
import com.mockproject.freetutsproject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
}
