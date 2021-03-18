package com.mockproject.freetutsproject.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.entity.DiscountEntity;
import com.mockproject.freetutsproject.mapper.DiscountMapper;
import com.mockproject.freetutsproject.repository.DiscountRepository;
import com.mockproject.freetutsproject.service.DiscountService;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService{
	
	@Autowired
	private DiscountRepository discountRepository;
	
	@Autowired
	private DiscountMapper discountMapper;

	@Override
	@Transactional (readOnly = true)
	public List<DiscountDTO> findAll() {
		List<DiscountEntity> entities = discountRepository.findAll(); 
		return entities.stream()
				.map(entity -> discountMapper.toDTO(entity))
				.collect(Collectors.toList());
	}
}
