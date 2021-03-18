package com.mockproject.freetutsproject.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDTO extends AbstractDTO<CommentDTO> {
	private String commenterName;
	private String commenterEmail;
	private Date date;
	private String comment;
	private Long postId;
	private Long courseId;
}