package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.ContentDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.mapper.PostMapper;
import com.mockproject.freetutsproject.repository.PostRepository;
import com.mockproject.freetutsproject.service.CommentService;
import com.mockproject.freetutsproject.service.ContentService;
import com.mockproject.freetutsproject.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private PostMapper postMapper;
	
	public PostDTO loadPostInfo(String name) {
		//1.Post
		PostEntity entity = this.postRepository.findByName(name);
		//Entity -> DTO
		PostDTO result = postMapper.toDTO(entity);
		
		return result;
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
