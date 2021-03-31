package com.mockproject.freetutsproject.mapper;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.entity.AdminEntity;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.repository.AdminRepository;
import com.mockproject.freetutsproject.repository.CategoryRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper implements GenericMapper<CourseEntity, CourseDTO >{

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public CourseDTO toDTO(CourseEntity entity) {
		CourseDTO dto = modelMapper.map(entity, CourseDTO.class);
		
		if (entity.getCreator() != null) {
			dto.setCreatorName(entity.getCreator().getFullname());
			dto.setCreatorId(entity.getCreator().getId());
		}
		
		if (entity.getCategory() != null) {
			dto.setCategoryId(entity.getCategory().getId());
			dto.setCategoryName(entity.getCategory().getName());
		}
		
		if (entity.getComments() != null) {
			List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>();
			entity.getComments().forEach(comment -> commentDTOs.add(commentMapper.toDTO(comment)));
			dto.setComments(commentDTOs);
		}

		if (entity.getOrders() != null){
			List<OrderDTO> orderDTOs = new ArrayList<>();
			entity.getOrders().forEach(order -> orderDTOs.add(orderMapper.toDTO(order)));
			dto.setListOrders(orderDTOs);
		}
		return dto;
	}

	@Override
	public CourseEntity toEntity(CourseDTO  dto) {
		CourseEntity entity = modelMapper.map(dto, CourseEntity.class);
		if (dto.getCategoryId() != null) {
			categoryRepository.findById(dto.getCategoryId()).ifPresent(entity::setCategory);
		}
		if (dto.getCreatorId() != null) {
			adminRepository.findById(dto.getCreatorId()).ifPresent(entity::setCreator);
		}
		return entity;
	}

	@Override
	public void toEntity(CourseDTO dto, CourseEntity entity) {
		modelMapper.map(dto,entity);
	}

}
