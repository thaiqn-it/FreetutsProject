package com.mockproject.freetutsproject.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.entity.CommentEntity;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.repository.PostRepository;

@Component
public class CommentMapper implements GenericMapper<CommentEntity, CommentDTO> {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CommentDTO toDTO(CommentEntity entity) {
		CommentDTO dto = modelMapper.map(entity, CommentDTO.class);
		
		if (entity.getPost() != null) {
			dto.setPostId(entity.getPost().getId());
		}
		
		if (entity.getCourse() != null) {
			dto.setCourseId(entity.getCourse().getId());
		}
		return dto;
	}

	@Override
	public CommentEntity toEntity(CommentDTO dto) {
		CommentEntity entity = modelMapper.map(dto, CommentEntity.class);
		if (dto.getPostId() != null) {
			PostEntity post = postRepository.findById(dto.getPostId()).orElse(null);
			if (post != null) entity.setPost(post);
		}
		
		if (dto.getCourseId() != null) {
			CourseEntity course = courseRepository.findById(dto.getCourseId()).orElse(null);
			if (course != null) entity.setCourse(course);
		}
		return entity;
	}

}
