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
	public List<DiscountDTO> findAllAndAvailableTrue() {
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
	public DiscountDTO updateStatus(boolean status, long id) {
		DiscountEntity entity = discountRepository.findById(id).orElse(null);
		if (entity != null){
			entity.setAvailable(status);
			return discountMapper.toDTO(discountRepository.save(entity));
		}
		return null;
	}

	@Override
	public DiscountDTO updateDiscount(DiscountDTO dto) {
		DiscountEntity entity = discountRepository.findById(dto.getId()).orElse(null);
		if(entity != null){
			entity.setDiscountCode(dto.getDiscountCode());
			entity.setDiscountPercent(dto.getDiscountPercent());
			entity.setDiscountWebsite(dto.getDiscountWebsite());
			entity.setProvider(dto.getProvider());
			return discountMapper.toDTO(discountRepository.save(entity));
		}
		return null;
	}

	@Override
	public List<DiscountDTO> findAll() {
		List<DiscountEntity> entities = discountRepository.findAll();
		return entities.stream()
				.map(entity -> discountMapper.toDTO(entity))
				.collect(Collectors.toList());
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
