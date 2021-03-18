package com.mockproject.freetutsproject.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.PostDTO ;
import com.mockproject.freetutsproject.entity.PostEntity;

@Component
public class PostMapper implements GenericMapper<PostEntity, PostDTO >{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public PostDTO toDTO(PostEntity entity) {
		PostDTO dto = modelMapper.map(entity, PostDTO.class);
		
		if (entity.getCategory() != null) {
			dto.setCategoryId(entity.getCategory().getId());
			dto.setCategoryName(entity.getCategory().getName());
		}
		
		if (entity.getCreator() != null) {
			dto.setCreatorName(entity.getCreator().getFullname());
		}
		
		if (entity.getComments() != null) {
			List<CommentDTO> commentList = new ArrayList<>();
			entity.getComments().forEach(comment -> commentList.add(commentMapper.toDTO(comment)));
			dto.setComments(commentList);
		}
		return dto;
	}

	@Override
	public PostEntity toEntity(PostDTO  dto) {
		PostEntity entity = modelMapper.map(dto, PostEntity.class);
		return entity;
	}

}
