package com.mockproject.freetutsproject.dto;

public class CourseDTO extends AbstractDTO<CourseDTO> {
	private String name;
	private String description;
	private String thumbnail;
	private String learnMethod;
	private String courseLink;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	/**
	 * @return the learnMethod
	 */
	public String getLearnMethod() {
		return learnMethod;
	}
	/**
	 * @param learnMethod the learnMethod to set
	 */
	public void setLearnMethod(String learnMethod) {
		this.learnMethod = learnMethod;
	}
	/**
	 * @return the courseLink
	 */
	public String getCourseLink() {
		return courseLink;
	}
	/**
	 * @param courseLink the courseLink to set
	 */
	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}
	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}
	private Long price;
}