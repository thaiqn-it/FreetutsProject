package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;

@Component
public class CategoryMapper implements GenericMapper<CategoryEntity, CategoryDTO>{

	@Override
	public CategoryDTO toDTO(CategoryEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity toEntity(CategoryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
