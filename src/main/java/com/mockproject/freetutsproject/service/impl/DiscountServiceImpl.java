package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.DiscountRepository;
import com.mockproject.freetutsproject.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService{
	
	@Autowired
	private DiscountRepository discountRepository;
}
