package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.entity.CommentEntity;

@Component
public class CommentMapper implements GenericMapper<CommentEntity, CommentDTO>{

	@Override
	public CommentDTO toDTO(CommentEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentEntity toEntity(CommentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
