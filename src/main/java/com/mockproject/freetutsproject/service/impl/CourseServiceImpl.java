package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.mapper.CourseMapper;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseMapper courseMapper;

	@Override
	public CourseDTO findCourseById(Long id) {
		CourseEntity entity = courseRepository.findById(id).orElse(null);
		
		if (entity != null) {
			return courseMapper.toDTO(entity);
		}
		return null;
	}
}
