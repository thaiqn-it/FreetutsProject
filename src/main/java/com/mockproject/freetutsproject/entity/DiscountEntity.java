package com.mockproject.freetutsproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "discounts")
public class DiscountEntity extends BaseEntity {
	
	@Column
	private int discountPercent;
	
	@Column
	private String discountWebsite;
	
	@Column
	private boolean available;

	/**
	 * @return the discountPercent
	 */
	public int getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * @param discountPercent the discountPercent to set
	 */
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * @return the discountWebsite
	 */
	public String getDiscountWebsite() {
		return discountWebsite;
	}

	/**
	 * @param discountWebsite the discountWebsite to set
	 */
	public void setDiscountWebsite(String discountWebsite) {
		this.discountWebsite = discountWebsite;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
