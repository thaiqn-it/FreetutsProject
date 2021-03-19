package com.mockproject.freetutsproject.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CourseDTO extends AbstractDTO<CourseDTO> {
	private String name;
	private String description;
	private String thumbnail;
	private String learnMethod;
	private String courseLink;
	private String creatorName;
	private Date createdDate;
	private Long categoryId;
	private String categoryName;
	private List<CommentDTO> comments;
	private Long price;
	
	private Long id;
	private boolean available;
}