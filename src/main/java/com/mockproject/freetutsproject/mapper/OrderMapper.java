package com.mockproject.freetutsproject.mapper;

import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.entity.AbstractEntity;
import com.mockproject.freetutsproject.entity.OrderEntity;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.repository.PaymentMethodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper implements GenericMapper<OrderEntity, OrderDTO >{

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public OrderDTO toDTO(OrderEntity entity) {
		OrderDTO dto = modelMapper.map(entity, OrderDTO.class);
		if (entity.getCourses() != null){
			dto.setCourseIds(entity.getCourses()
									.stream()
									.map(AbstractEntity::getId)
									.collect(Collectors.toList()));
		}
		return dto;
	}

	@Override
	public OrderEntity toEntity(OrderDTO  dto) {
		OrderEntity entity = modelMapper.map(dto, OrderEntity.class);

		entity.setAvailable(true);
		paymentMethodRepository.findById(dto.getPaymentMethod()).ifPresent(entity::setPaymentMethod);

		dto.getCourseIds().forEach(courseId -> courseRepository
												.findById(courseId)
												.ifPresent(entity.getCourses()::add));
		return entity;
	}

}
