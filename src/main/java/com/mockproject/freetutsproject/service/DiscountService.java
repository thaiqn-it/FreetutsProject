package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.DiscountDTO;

public interface DiscountService {
	List<DiscountDTO> findAll();
}
