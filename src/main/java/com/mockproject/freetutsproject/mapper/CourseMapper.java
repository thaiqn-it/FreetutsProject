package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CourseDTO ;
import com.mockproject.freetutsproject.entity.CourseEntity;

@Component
public class CourseMapper implements GenericMapper<CourseEntity, CourseDTO >{

	@Override
	public CourseDTO toDTO(CourseEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseEntity toEntity(CourseDTO  dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
