package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.entity.OrderEntity;
import com.mockproject.freetutsproject.mapper.OrderMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockproject.freetutsproject.repository.OrderRepository;
import com.mockproject.freetutsproject.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	@Transactional
	public OrderDTO save(OrderDTO orderDTO) {
		OrderEntity entity = orderMapper.toEntity(orderDTO);
		return orderMapper.toDTO(orderRepository.save(entity));
	}

	@Override
	@Transactional (readOnly = true)
	public List<OrderDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public OrderDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
