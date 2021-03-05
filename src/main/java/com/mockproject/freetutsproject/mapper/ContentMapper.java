package com.mockproject.freetutsproject.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.ContentDTO ;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.ContentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

@Component
public class ContentMapper implements GenericMapper<ContentEntity, ContentDTO >{
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ContentDTO toDTO(ContentEntity entity) {
		ContentDTO dto = modelMapper.map(entity, ContentDTO.class);
		return dto;
	}

	@Override
	public ContentEntity toEntity(ContentDTO  dto) {
		ContentEntity entity = modelMapper.map(dto, ContentEntity.class);
		return entity;
	}

}
