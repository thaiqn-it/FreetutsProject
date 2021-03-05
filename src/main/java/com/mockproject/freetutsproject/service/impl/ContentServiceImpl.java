package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.dto.ContentDTO;
import com.mockproject.freetutsproject.entity.ContentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.mapper.ContentMapper;
import com.mockproject.freetutsproject.repository.ContentRepository;
import com.mockproject.freetutsproject.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;

	@Autowired
	private ContentMapper contentMapper;
	
	@Override
	public List<ContentDTO> loadContentsByPost(PostEntity post) {
		List<ContentDTO> result = new ArrayList<ContentDTO>();
		List<ContentEntity> entities = this.contentRepository.findByPost(post);
		
		entities.forEach(entity -> {
			result.add(contentMapper.toDTO(entity));
		});
		return result;
	}
}
