package com.mockproject.freetutsproject.mapper;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.DiscountDTO ;
import com.mockproject.freetutsproject.entity.DiscountEntity;

@Component
public class DiscountMapper implements GenericMapper<DiscountEntity, DiscountDTO >{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public DiscountDTO toDTO(DiscountEntity entity) {
		DiscountDTO dto = modelMapper.map(entity, DiscountDTO.class);
		return dto;
	}

	@Override
	public DiscountEntity toEntity(DiscountDTO  dto) {
		DiscountEntity entity = modelMapper.map(dto, DiscountEntity.class);
		return entity;
	}

	@Override
	public void toEntity(DiscountDTO dto, DiscountEntity entity) {
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(dto,entity);
	}

}
