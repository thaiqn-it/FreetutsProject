package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity (name = "CategoryTbl")
public class CategoryEntity extends BaseEntity {
	
	@Column
	private String name;
	
	@Column
	private String thumbnail;
	
	@ManyToOne
	@JoinColumn (name = "parent_id")
	private CategoryEntity parent;
	
	@OneToMany (mappedBy = "parent")
	private List<CategoryEntity> subCategories = new ArrayList<CategoryEntity>();
	
	@ManyToOne
	@JoinColumn (name = "created_by")
	private AdminEntity creator;
	
	@OneToMany (mappedBy = "category")
	private List<CourseEntity> courses = new ArrayList<CourseEntity>();

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
	 * @return the parent
	 */
	public CategoryEntity getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(CategoryEntity parent) {
		this.parent = parent;
	}

	/**
	 * @return the subCategories
	 */
	public List<CategoryEntity> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<CategoryEntity> subCategories) {
		this.subCategories = subCategories;
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
	 * @return the courses
	 */
	public List<CourseEntity> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}
	
	
}
