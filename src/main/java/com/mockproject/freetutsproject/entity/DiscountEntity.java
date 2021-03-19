package com.mockproject.freetutsproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "discounts")
public class DiscountEntity extends AbstractEntity {
	
	@Column
	private String discountCode;
	
	@Column
	private String discountWebsite;
	
	@Column
	private String provider;
	
	@Column
	private int discountPercent;
}