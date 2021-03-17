package com.mockproject.freetutsproject.mapper;

import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.entity.PaymentMethodEntity;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.repository.PaymentMethodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.OrderDTO ;
import com.mockproject.freetutsproject.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity toEntity(OrderDTO  dto) {
		OrderEntity entity = modelMapper.map(dto, OrderEntity.class);

		entity.setAvailable(true);

		PaymentMethodEntity paymentMethodEntity = paymentMethodRepository.findById(dto.getPaymentMethod()).orElse(null);
		entity.setPaymentMethod(paymentMethodEntity);

		CourseEntity courseEntity = courseRepository.findById(dto.getCourseId()).orElse(null);
		if (courseEntity != null){
			entity.getCourses().add(courseEntity);
		}
		return entity;
	}

}
