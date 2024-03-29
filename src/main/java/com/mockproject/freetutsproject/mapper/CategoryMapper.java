package com.mockproject.freetutsproject.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

@Component
public class CategoryMapper implements GenericMapper<CategoryEntity, CategoryDTO> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = modelMapper.map(entity, CategoryDTO.class);
		if (entity.getParent() != null) {
			dto.setParentId(entity.getParent().getId());
		}
		
		// Mapping create by
		if (entity.getCreator() != null) {
			dto.setCreatedBy(entity.getCreator().getFullname());
		}

		// Mapping subcategories
		List<CategoryEntity> subCategoryEnities = entity.getSubCategories();
		if (!subCategoryEnities.isEmpty()) {
			dto.setSubCategories(new ArrayList<CategoryDTO>());

			// Iterate through sub categories
			subCategoryEnities.forEach(subCategory -> {
				dto.getSubCategories().add(toDTO(subCategory));
			});
		}

		// Mapping posts
		List<PostEntity> postEnities = entity.getPosts();
		if (!postEnities.isEmpty()) {
			dto.setPosts(new ArrayList<PostDTO>());

			// Iterate through posts
			postEnities.forEach(post -> {
				dto.getPosts().add(postMapper.toDTO(post));
			});
		}

		// Mapping courses
		List<CourseEntity> coursreEnities = entity.getCourses();
		if (!coursreEnities.isEmpty()) {
			dto.setCourses(new ArrayList<CourseDTO>());

			// Iterate through courses
			coursreEnities.forEach(course -> {
				dto.getCourses().add(courseMapper.toDTO(course));
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
