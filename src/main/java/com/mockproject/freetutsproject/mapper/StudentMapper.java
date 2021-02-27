package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.StudentDTO ;
import com.mockproject.freetutsproject.entity.StudentEntity;

@Component
public class StudentMapper implements GenericMapper<StudentEntity, StudentDTO >{

	@Override
	public StudentDTO toDTO(StudentEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentEntity toEntity(StudentDTO  dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
