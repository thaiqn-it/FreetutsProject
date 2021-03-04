package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<CourseDTO> loadCourses() {
		List<CourseDTO> dto = new ArrayList<>();
		List<CourseEntity> entities = courseRepository.findCourseEntitiesByCategory();

		entities.forEach(entity -> {
			dto.add(courseMapper.toDTO(entity));
		});
		return dto;
	}
}
