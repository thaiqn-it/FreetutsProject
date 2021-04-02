package com.mockproject.freetutsproject.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

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
	private MultipartFile image;
}