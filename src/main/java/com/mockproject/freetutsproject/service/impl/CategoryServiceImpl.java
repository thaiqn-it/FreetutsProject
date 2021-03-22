package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.repository.CategoryRepository;
import com.mockproject.freetutsproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	@Transactional (readOnly = true)
	public List<CategoryDTO> loadTopLevelCategories() {
		List<CategoryDTO> result = new ArrayList<CategoryDTO>();
		List<CategoryEntity> entities = categoryRepository.findByParentIsNullAndAvailableTrue();
		
		entities.forEach(entity -> {
			result.add(categoryMapper.toDTO(entity));
		});
		return result;
	}

	@Override
	@Transactional (readOnly = true)
	public CategoryDTO findById(Long id) {
		CategoryEntity entity = categoryRepository.findByIdAndAvailableTrue(id);
		
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
	public List<CategoryDTO> findBySubCategoriesIsNull() {
		List<CategoryEntity> entities = categoryRepository.findBySubCategoriesIsNull();
		if (!entities.isEmpty()){
			return entities.stream()
							.map(entity -> categoryMapper.toDTO(entity))
							.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<CategoryDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO t) {
		// TODO Auto-generated method stub
		return null;
	}
}
