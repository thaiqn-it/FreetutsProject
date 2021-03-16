package com.mockproject.freetutsproject.dto;

public class DiscountDTO extends AbstractDTO<DiscountDTO> {
	private String discountCode;
	private String discountWebsite;
	private String provider;
	private int discountPercent;
	/**
	 * @return the discountCode
	 */
	public String getDiscountCode() {
		return discountCode;
	}
	/**
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
	
	
}