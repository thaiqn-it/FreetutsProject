package com.mockproject.freetutsproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.entity.CommentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.mapper.CommentMapper;
import com.mockproject.freetutsproject.repository.CommentRepository;
import com.mockproject.freetutsproject.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentMapper commentMapper; 
	
	@Override
	@Transactional (readOnly = true)
	public List<CommentDTO> loadCommentsByPost(PostEntity post) {
		List<CommentDTO> result = new ArrayList<CommentDTO>();
		List<CommentEntity> entities = this.commentRepository.findByPost(post);
		
		entities.forEach(entity -> {
			result.add(commentMapper.toDTO(entity));
		});
		return result;
	}

	@Override
	public CommentDTO save(CommentDTO dto) {
		CommentEntity entity = commentMapper.toEntity(dto);
		return commentMapper.toDTO(commentRepository.save(entity));
	}
}
