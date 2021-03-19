package com.mockproject.freetutsproject.dto;

import java.util.List;

import lombok.Data;

@Data
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
	
	private Long id;
	private boolean available;
}