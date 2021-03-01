package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.PaymentMethodRepository;
import com.mockproject.freetutsproject.service.PaymentMethodService;

@Service
public class PaymentMethodSerivceImpl implements PaymentMethodService {

	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
}
