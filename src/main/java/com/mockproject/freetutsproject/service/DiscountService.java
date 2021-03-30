package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.DiscountDTO;

import java.util.List;

public interface DiscountService extends AbstractService<DiscountDTO> {
    List<DiscountDTO> findAllAndAvailableTrue();

    boolean checkCodeExist(String code);

    DiscountDTO updateStatus(boolean status, long id);

    DiscountDTO updateDiscount(DiscountDTO dto);
}
