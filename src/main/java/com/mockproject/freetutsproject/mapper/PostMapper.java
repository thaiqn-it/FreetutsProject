package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.PostDTO ;
import com.mockproject.freetutsproject.entity.PostEntity;

@Component
public class PostMapper implements GenericMapper<PostEntity, PostDTO >{

	@Override
	public PostDTO toDTO(PostEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostEntity toEntity(PostDTO  dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
