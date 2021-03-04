package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.repository.CategoryRepository;
import com.mockproject.freetutsproject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<CategoryDTO> loadCategories() {
		List<CategoryDTO> result = new ArrayList<CategoryDTO>();
		List<CategoryEntity> entities = categoryRepository.findByParentIsNull();
		
		entities.forEach(entity -> {
			result.add(categoryMapper.toDTO(entity));
		});
		return result;
	}

	@Override
	public CategoryDTO findCategory(Long id) {
		CategoryEntity entity = categoryRepository.findById(id).orElse(null);
		
		if (entity != null) {
			return categoryMapper.toDTO(entity);
		}
		return null;
	}
}
