package com.mockproject.freetutsproject.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CourseDTO extends AbstractDTO<CourseDTO> {
	private String name;
	private String description;
	private String thumbnail;
	private String learnMethod;
	private String courseLink;
	private String creatorName;
	private Long creatorId;
	private Date createdDate;
	private Long categoryId;
	private String categoryName;
	private List<CommentDTO> comments;
	private Long price;
}