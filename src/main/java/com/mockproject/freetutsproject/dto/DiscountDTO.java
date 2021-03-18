package com.mockproject.freetutsproject.dto;

import lombok.Data;

@Data
public class DiscountDTO extends AbstractDTO<DiscountDTO> {
	private String discountCode;
	private String discountWebsite;
	private String provider;
	private int discountPercent;
}