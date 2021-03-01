package com.mockproject.freetutsproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.mockproject.freetutsproject.entity.CategoryEntity;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	// Add more fields which use to show on frontend
	private Long id;
	private String name;
	private String thumbnail;
	private CategoryEntity parent;
	private List<CategoryEntity> subCategories = new ArrayList<CategoryEntity>();
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
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
	
	
}