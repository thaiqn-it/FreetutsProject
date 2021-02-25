package com.mockproject.freetutsproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "discounts")
public class DiscountEntity extends BaseEntity {
	
	@Column
	private int percent;
	
	@Column
	private String discountWebsite;
	
	@Column
	private boolean available;

	/**
	 * @return the percent
	 */
	public int getPercent() {
		return percent;
	}

	/**
	 * @param percent the percent to set
	 */
	public void setPercent(int percent) {
		this.percent = percent;
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
