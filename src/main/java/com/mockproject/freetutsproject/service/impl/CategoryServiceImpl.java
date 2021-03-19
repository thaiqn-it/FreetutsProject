package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.repository.CategoryRepository;
import com.mockproject.freetutsproject.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	@Transactional (readOnly = true)
	public List<CategoryDTO> loadCategories() {
		List<CategoryDTO> result = new ArrayList<CategoryDTO>();
		List<CategoryEntity> entities = categoryRepository.findByParentIsNull();
		
		entities.forEach(entity -> {
			result.add(categoryMapper.toDTO(entity));
		});
		return result;
	}

	@Override
	@Transactional (readOnly = true)
	public CategoryDTO findById(Long id) {
		CategoryEntity entity = categoryRepository.findById(id).orElse(null);
		
		if (entity != null) {
			return categoryMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public CategoryDTO findCategory(String name) {
		CategoryEntity entity = categoryRepository.findOneByName(name);
		
		if (entity != null) {
			return categoryMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		if(!entities.isEmpty()){
			List<CategoryDTO> DTOs = new ArrayList<>();
			entities.forEach(entity -> DTOs.add(categoryMapper.toDTO(entity)));
			return DTOs;
		}
		return null;
	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO t) {
		// TODO Auto-generated method stub
		return null;
	}
}
