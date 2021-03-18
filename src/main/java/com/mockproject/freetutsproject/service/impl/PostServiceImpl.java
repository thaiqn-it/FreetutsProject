package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.mapper.PostMapper;
import com.mockproject.freetutsproject.repository.PostRepository;
import com.mockproject.freetutsproject.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private PostMapper postMapper;

	@Autowired
	private MultiLevelCategoryUtil multiLevelCategoryUtil;
	
	@Override
	public PostDTO findById(Long id) {
		PostEntity entity = this.postRepository.findById(id).orElse(null);
		
		if (entity != null) {
			return postMapper.toDTO(entity);
		
		}
		return null;
	}

	@Override
	public List<PostDTO> findPostByCategoryAndOrderedByIdLimitedTo(CategoryDTO categoryDTO, int limit) {
		if (!categoryDTO.getPosts().isEmpty()){
			List<PostDTO> originalPostList = categoryDTO.getPosts();
			List<PostDTO> postDTOList = new ArrayList<>();
			Collections.reverse(originalPostList);
			for (int i = 0; i < limit; i++) {
				postDTOList.add(originalPostList.get(i));
			}
			return postDTOList;
		}

		List<PostEntity> postEntityList;
		List<CategoryDTO> lastLevelCategories = multiLevelCategoryUtil.findAllLastLevelSubCategroies(categoryDTO);
		List<Long> ids = new ArrayList<>();
		lastLevelCategories.forEach(category -> ids.add(category.getId()));
		postEntityList = postRepository.findPostByCategoriesAndOrderedByIdLimitedTo(ids,5);
		if (!postEntityList.isEmpty()) {
			List<PostDTO> postDTOList = new ArrayList<PostDTO>();
			postEntityList.forEach(entity -> postDTOList.add(postMapper.toDTO(entity)));
			return postDTOList;
		}
		return null;
	}

	@Override
	public List<PostDTO> findPostByCategory(CategoryDTO category) {
		CategoryEntity categoryEntity = categoryMapper.toEntity(category);
		List<PostEntity> entityList = postRepository.findByCategory(categoryEntity);
		
		if (entityList != null) {
			List<PostDTO> dtoList = new ArrayList<PostDTO>();
			entityList.forEach(entity -> dtoList.add(postMapper.toDTO(entity)));
			return dtoList;
		}
		
		return null;
	}
}
