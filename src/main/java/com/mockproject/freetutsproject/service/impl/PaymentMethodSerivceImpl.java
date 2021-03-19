package com.mockproject.freetutsproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockproject.freetutsproject.dto.PaymentMethodDTO;
import com.mockproject.freetutsproject.repository.PaymentMethodRepository;
import com.mockproject.freetutsproject.service.PaymentMethodService;

@Service
@Transactional
public class PaymentMethodSerivceImpl implements PaymentMethodService {

	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

	@Override
	@Transactional (readOnly = true)
	public List<PaymentMethodDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public PaymentMethodDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public PaymentMethodDTO save(PaymentMethodDTO t) {
		// TODO Auto-generated method stub
		return null;
	}
}
