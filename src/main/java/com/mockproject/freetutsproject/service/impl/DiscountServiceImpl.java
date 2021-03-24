package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.entity.DiscountEntity;
import com.mockproject.freetutsproject.mapper.DiscountMapper;
import com.mockproject.freetutsproject.repository.DiscountRepository;
import com.mockproject.freetutsproject.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
		List<DiscountEntity> entities = discountRepository.findAllByAvailableTrue();
		return entities.stream()
				.map(entity -> discountMapper.toDTO(entity))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional (readOnly = true)
	public boolean checkCodeExist(String code) {
		return discountRepository.existsByDiscountCode(code);
	}

	@Override
	@Transactional (readOnly = true)
	public DiscountDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public DiscountDTO save(DiscountDTO discountDTO) {
		DiscountEntity entity = discountRepository.save(discountMapper.toEntity(discountDTO));
		return discountMapper.toDTO(entity);
	}


}
