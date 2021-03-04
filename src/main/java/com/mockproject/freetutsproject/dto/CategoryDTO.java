package com.mockproject.freetutsproject.dto;

import java.util.List;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	// Add more fields which use to show on frontend
	private String name;
	private String description;
	private String thumbnail;
	private Long parentId;
	private List<CategoryDTO> subCategories;
	private String createdBy;
	private List<PostDTO> posts;
	private List<CourseDTO> courses;
	
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the posts
	 */
	public List<PostDTO> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<PostDTO> posts) {
		this.posts = posts;
	}
	/**
	 * @return the courses
	 */
	public List<CourseDTO> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
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
	 * @return the subCategories
	 */
	public List<CategoryDTO> getSubCategories() {
		return subCategories;
	}
	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<CategoryDTO> subCategories) {
		this.subCategories = subCategories;
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
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}