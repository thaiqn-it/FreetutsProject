package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.repository.CategoryRepository;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.util.FileUtil;
import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

	@Autowired
	private MultiLevelCategoryUtil multiLevelCategoryUtil;

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
	public CategoryDTO updateCategory(CategoryDTO dto) throws IOException {
		//entity
		CategoryEntity moveEntity = categoryRepository.findById(dto.getId()).orElse(null);
		CategoryEntity replaceEntity = categoryRepository.findById(dto.getParentId()).orElse(null);

		//DTO
		CategoryDTO topCategory = multiLevelCategoryUtil.getTopCategory(categoryMapper.toDTO(replaceEntity));

		if (replaceEntity != null){
			// Process categoryId
			if (topCategory.getId() == moveEntity.getId()){
				if (replaceEntity.getParent().getId() != topCategory.getId()){
					moveCategoryRecursive(moveEntity,replaceEntity);
				} else {
					replaceEntity.setParent(moveEntity.getParent());
					categoryRepository.save(replaceEntity);
				}
			}
			moveEntity.setParent(replaceEntity);

			// Process attribute
			if (dto.getImage() != null){
				String imageName = fileUtil.writeImageHardDisk(dto.getImage());
				dto.setThumbnail(imageName);
			}
			categoryMapper.toEntity(dto, moveEntity);
			if (dto.getParentId() == 0){
				moveEntity.setParent(null);
			}

			return categoryMapper.toDTO(categoryRepository.save(moveEntity));
		}
		return null;
	}

	private void moveCategoryRecursive(CategoryEntity moveEntity, CategoryEntity replaceEntity){
		if (replaceEntity.getParent().getId().equals(moveEntity.getId())){
			replaceEntity.setParent(moveEntity.getParent());
			categoryRepository.save(replaceEntity);
		}
		else {
			moveCategoryRecursive(moveEntity, replaceEntity.getParent());
		}
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
	public CategoryDTO updateStatus(boolean status, long id) {
		CategoryEntity oldEntity = categoryRepository.findById(id).orElse(null);
		if (oldEntity != null){
			oldEntity.setAvailable(status);
			return categoryMapper.toDTO(categoryRepository.save(oldEntity));
		}
		return null;
	}
}
