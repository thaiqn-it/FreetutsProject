package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.OrderRepository;
import com.mockproject.freetutsproject.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
}
