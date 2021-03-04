package com.mockproject.freetutsproject.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CourseDTO ;
import com.mockproject.freetutsproject.entity.CourseEntity;

@Component
public class CourseMapper implements GenericMapper<CourseEntity, CourseDTO >{

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CourseDTO toDTO(CourseEntity entity) {
		CourseDTO dto = modelMapper.map(entity, CourseDTO.class);
		return dto;
	}

	@Override
	public CourseEntity toEntity(CourseDTO  dto) {
		CourseEntity entity = modelMapper.map(dto, CourseEntity.class);
		return entity;
	}

}
