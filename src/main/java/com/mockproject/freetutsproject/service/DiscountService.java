package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.DiscountDTO;

import java.util.List;

public interface DiscountService extends AbstractService<DiscountDTO>{
	List<DiscountDTO> findAll();
	boolean checkCodeExist(String code);
}
