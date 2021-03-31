package com.mockproject.freetutsproject.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.AdminDTO;
import com.mockproject.freetutsproject.entity.AdminEntity;

@Component
public class AdminMapper implements GenericMapper<AdminEntity, AdminDTO>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AdminDTO toDTO(AdminEntity entity) {
		AdminDTO dto = modelMapper.map(entity, AdminDTO.class);
		return dto;
	}

	@Override
	public AdminEntity toEntity(AdminDTO dto) {
		AdminEntity entity = modelMapper.map(dto, AdminEntity.class);
		return entity;
	}

	@Override
	public void toEntity(AdminDTO dto, AdminEntity entity) {

	}

}
