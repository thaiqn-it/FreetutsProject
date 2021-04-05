package com.mockproject.freetutsproject.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	// Add more fields which use to show on frontend
	private String name;
	private String description;
	private String thumbnail;
	private Long parentId;
	private List<CategoryDTO> subCategories;
	private String creatorName;
	private Long creatorId;
	private List<PostDTO> posts;
	private List<CourseDTO> courses;
	private MultipartFile image;
}