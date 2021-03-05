package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.ContentDTO;
import com.mockproject.freetutsproject.entity.CommentEntity;
import com.mockproject.freetutsproject.entity.ContentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.mapper.CommentMapper;
import com.mockproject.freetutsproject.repository.CommentRepository;
import com.mockproject.freetutsproject.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentMapper commentMapper; 
	
	@Override
	public List<CommentDTO> loadCommentsByPost(PostEntity post) {
		List<CommentDTO> result = new ArrayList<CommentDTO>();
		List<CommentEntity> entities = this.commentRepository.findByPost(post);
		
		entities.forEach(entity -> {
			result.add(commentMapper.toDTO(entity));
		});
		return result;
	}
}
