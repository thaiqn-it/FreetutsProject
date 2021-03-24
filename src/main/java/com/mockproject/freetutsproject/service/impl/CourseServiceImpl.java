package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.mapper.CourseMapper;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
		List<CourseEntity> entities = courseRepository.findAll();

		if (!entities.isEmpty()) {
			List<CourseDTO> DTOs = new ArrayList<CourseDTO>();
			entities.forEach(entity -> DTOs.add(courseMapper.toDTO(entity)));
			return DTOs;
		}
		return null;
	}

	@Override
	@Transactional
	public CourseDTO save(CourseDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void updateStatus(boolean status, CourseDTO dto) {
		CourseEntity entity = courseMapper.toEntity(dto);
		entity.setAvailable(!status);
		courseRepository.save(entity);
	}
}
