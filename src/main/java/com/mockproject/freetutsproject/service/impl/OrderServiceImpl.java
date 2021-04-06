package com.mockproject.freetutsproject.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.mockproject.freetutsproject.dto.OrderDTO;
import com.mockproject.freetutsproject.entity.OrderEntity;
import com.mockproject.freetutsproject.mapper.OrderMapper;
import com.mockproject.freetutsproject.repository.OrderRepository;
import com.mockproject.freetutsproject.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		List<OrderEntity> entities = orderRepository.findAll();
		return entities.stream()
				.map(entity -> orderMapper.toDTO(entity))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional (readOnly = true)
	public OrderDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO updateStatus(boolean status, long id) {
		OrderEntity entity = orderRepository.findById(id).orElse(null);
		if (entity != null){
			entity.setAvailable(status);
			return orderMapper.toDTO(orderRepository.save(entity));
		}
		return null;
	}
}
