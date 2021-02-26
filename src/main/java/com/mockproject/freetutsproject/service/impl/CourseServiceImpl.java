package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
}
