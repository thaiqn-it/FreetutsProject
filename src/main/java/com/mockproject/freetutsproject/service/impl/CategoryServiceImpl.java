package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.repository.CategoryRepository;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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

	@Autowired
	private FileUtil fileUtil;

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
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		CategoryEntity entity = categoryRepository.findById(id).orElse(null);
		if (entity != null) {
			return categoryMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
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
		List<CategoryEntity> entities = categoryRepository.findBySubCategoriesIsNullAndAvailableTrue();
		if (!entities.isEmpty()){
			return entities.stream()
							.map(entity -> categoryMapper.toDTO(entity))
							.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<CategoryDTO> findByParentId(long id) {
		List<CategoryEntity> entities = categoryRepository.findByParentId(id);
		if (!entities.isEmpty()){
			return entities.stream()
					.map(entity -> categoryMapper.toDTO(entity))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public CategoryDTO findByIdAndAvailableTrue(long id) {
		CategoryEntity entity = categoryRepository.findByIdAndAvailableTrue(id);
		if (entity != null) {
			return categoryMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		if (!entities.isEmpty()){
			return entities.stream()
					.map(entity -> categoryMapper.toDTO(entity))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO categoryDTO) {
		String imageName = null;
		try {
			imageName = fileUtil.writeImageHardDisk(categoryDTO.getImage());

			categoryDTO.setThumbnail(imageName);

			CategoryEntity entity = categoryMapper.toEntity(categoryDTO);
			return categoryMapper.toDTO(categoryRepository.save(entity));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public void updateStatus(boolean status, CategoryDTO dto) {
		CategoryEntity oldEntity = categoryRepository.findById(dto.getId()).orElse(null);
		if (oldEntity != null){
			oldEntity.setAvailable(!status);

		}
		categoryRepository.save(oldEntity);
	}
}
