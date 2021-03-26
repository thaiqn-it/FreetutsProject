package com.mockproject.freetutsproject.mapper;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.repository.AdminRepository;
import com.mockproject.freetutsproject.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper implements GenericMapper<PostEntity, PostDTO >{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public PostDTO toDTO(PostEntity entity) {
		PostDTO dto = modelMapper.map(entity, PostDTO.class);
		
		if (entity.getCategory() != null) {
			dto.setCategoryId(entity.getCategory().getId());
			dto.setCategoryName(entity.getCategory().getName());
		}
		
		if (entity.getCreator() != null) {
			dto.setCreatorName(entity.getCreator().getFullname());
			dto.setCreatorId(entity.getCreator().getId());
		}
		
		if (entity.getComments() != null) {
			List<CommentDTO> commentList = new ArrayList<>();
			entity.getComments().forEach(comment -> commentList.add(commentMapper.toDTO(comment)));
			dto.setComments(commentList);
		}
		return dto;
	}

	@Override
	public PostEntity toEntity(PostDTO  dto) {
		PostEntity entity = modelMapper.map(dto, PostEntity.class);
//		if (dto.getCategoryId() != null) {
//			categoryRepository.findById(dto.getCategoryId()).ifPresent(entity::setCategory);
//		}
//		if (dto.getCreatorId() != null) {
//			adminRepository.findById(dto.getCreatorId()).ifPresent(entity::setCreator);
//		}
		return entity;
	}

}
