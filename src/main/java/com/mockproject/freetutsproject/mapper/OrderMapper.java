package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.OrderDTO ;
import com.mockproject.freetutsproject.entity.OrderEntity;

@Component
public class OrderMapper implements GenericMapper<OrderEntity, OrderDTO >{

	@Override
	public OrderDTO toDTO(OrderEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity toEntity(OrderDTO  dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
