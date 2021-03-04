package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "courses")
public class CourseEntity extends BaseEntity{
	
	@Column(columnDefinition = "nvarchar(50)")
	private String name;
	
	@Column(columnDefinition = "ntext")
	private String description;
	
	@Column
	private String thumbnail;
	
	@Column
	private String learnMethod;
	
	@Column
	private String courseLink;
	
	@Column
	private Long price;
	
	@ManyToOne
	@JoinColumn (name = "created_by")
	private AdminEntity creator;
	
	@ManyToOne
	@JoinColumn (name = "category")
	private CategoryEntity category;
	
	@ManyToMany (mappedBy = "courses")
	private List<OrderEntity> orders = new ArrayList<OrderEntity>();

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

	/**
	 * @return the creator
	 */
	public AdminEntity getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(AdminEntity creator) {
		this.creator = creator;
	}

	/**
	 * @return the category
	 */
	public CategoryEntity getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	/**
	 * @return the orders
	 */
	public List<OrderEntity> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	
	
}
