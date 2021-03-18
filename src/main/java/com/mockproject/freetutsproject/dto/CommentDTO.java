package com.mockproject.freetutsproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO extends AbstractDTO<CommentDTO> {
	private String commenterName;
	private String commenterEmail;
	private Date date;
	private String comment;
	private Long postId;
	private Long courseId;
}