package com.mockproject.freetutsproject.mapper;

import org.springframework.stereotype.Component;

import com.mockproject.freetutsproject.dto.PaymentMethodDTO ;
import com.mockproject.freetutsproject.entity.PaymentMethodEntity;

@Component
public class PaymentMedthodMapper implements GenericMapper<PaymentMethodEntity, PaymentMethodDTO >{

	@Override
	public PaymentMethodDTO toDTO(PaymentMethodEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentMethodEntity toEntity(PaymentMethodDTO  dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void toEntity(PaymentMethodDTO dto, PaymentMethodEntity entity) {

	}

}
