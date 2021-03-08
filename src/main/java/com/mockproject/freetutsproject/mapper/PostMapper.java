package com.mockproject.freetutsproject.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.mockproject.freetutsproject.dto.PostDTO ;
import com.mockproject.freetutsproject.entity.PostEntity;

@Component
public class PostMapper implements GenericMapper<PostEntity, PostDTO >{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PostDTO toDTO(PostEntity entity) {
		PostDTO dto = modelMapper.map(entity, PostDTO.class);
		return dto;
	}

	@Override
	public PostEntity toEntity(PostDTO  dto) {
		PostEntity entity = modelMapper.map(dto, PostEntity.class);
		return entity;
	}

}
