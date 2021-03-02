package com.mockproject.freetutsproject.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;

@Component
public class CategoryMapper implements GenericMapper<CategoryEntity, CategoryDTO>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = modelMapper.map(entity, CategoryDTO.class);
		if (entity.getParent() != null) {
			dto.setParentId(entity.getParent().getId());
		}
		
		List<CategoryEntity> subCategoryEnities = entity.getSubCategories();
		if (!subCategoryEnities.isEmpty()) {
			dto.setSubCategories(new ArrayList<CategoryDTO>());
			
			// Iterate through sub categories
			subCategoryEnities.forEach(subCategory -> {
				dto.getSubCategories().add(toDTO(subCategory));
			});
		}
		return dto;
	}

	@Override
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = modelMapper.map(dto, CategoryEntity.class);
		return entity;
	}

}
