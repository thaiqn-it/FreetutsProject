package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.ContentDTO ;
import com.mockproject.freetutsproject.entity.ContentEntity;

@Component
public class ContentMapper implements GenericMapper<ContentEntity, ContentDTO >{

	@Override
	public ContentDTO toDTO(ContentEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentEntity toEntity(ContentDTO  dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
