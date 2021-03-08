package com.mockproject.freetutsproject.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.CommentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

@Component
public class CommentMapper implements GenericMapper<CommentEntity, CommentDTO> {
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDTO toDTO(CommentEntity entity) {
		CommentDTO dto = modelMapper.map(entity, CommentDTO.class);
		return dto;
	}

	@Override
	public CommentEntity toEntity(CommentDTO dto) {
		CommentEntity entity = modelMapper.map(dto, CommentEntity.class);
		return entity;
	}

}
