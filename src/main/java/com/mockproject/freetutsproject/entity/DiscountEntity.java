package com.mockproject.freetutsproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "discounts")
public class DiscountEntity extends BaseEntity {
	
	@Column
	private String discountCode;
	
	@Column
	private String discountWebsite;
	
	@Column
	private String provider;
	
	@Column
	private int discountPercent;
	
	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

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
	 * @return the discountCode
	 */
	public String getDiscountCode() {
		return discountCode;
	}

	/**W
	 * @param discountCode the discountCode to set
	 */
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
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
	
}
