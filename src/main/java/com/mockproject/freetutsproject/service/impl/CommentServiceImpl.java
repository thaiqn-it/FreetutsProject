package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.entity.CommentEntity;
import com.mockproject.freetutsproject.mapper.CommentMapper;
import com.mockproject.freetutsproject.repository.CommentRepository;
import com.mockproject.freetutsproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentMapper commentMapper; 
	

	@Override
	@Transactional
	public CommentDTO save(CommentDTO dto) {
		CommentEntity entity = commentMapper.toEntity(dto);
		return commentMapper.toDTO(commentRepository.save(entity));
	}

	@Override
	@Transactional (readOnly = true)
	public List<CommentDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public CommentDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
