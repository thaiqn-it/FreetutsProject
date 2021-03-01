package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.DiscountDTO ;
import com.mockproject.freetutsproject.entity.DiscountEntity;

@Component
public class DiscountMapper implements GenericMapper<DiscountEntity, DiscountDTO >{

	@Override
	public DiscountDTO toDTO(DiscountEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscountEntity toEntity(DiscountDTO  dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
