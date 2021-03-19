package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.mapper.CourseMapper;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseMapper courseMapper;

	@Override
	@Transactional (readOnly = true)
	public CourseDTO findById(Long id) {
		CourseEntity entity = courseRepository.findById(id).orElse(null);
		
		if (entity != null) {
			return courseMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<CourseDTO> findTopFiveNewestCourse() {
		List<CourseEntity> entities = courseRepository.findTop5ByOrderByIdDesc();
		
		if (entities != null) {
			List<CourseDTO> dtos = new ArrayList<CourseDTO>();
			entities.forEach(entity -> {
				dtos.add(courseMapper.toDTO(entity));
			});
			
			return dtos;
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<CourseDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CourseDTO save(CourseDTO t) {
		// TODO Auto-generated method stub
		return null;
	}
}
