package com.mockproject.freetutsproject.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostDTO extends AbstractDTO<PostDTO> {
	private String name;
	private String description;
	private Date createdDate;
	private String thumbnail;
	private String creatorName;
	private Long creatorId;
	private Long categoryId;
	private String categoryName;
	private String contentFile ;
	private List<CommentDTO> comments;
}