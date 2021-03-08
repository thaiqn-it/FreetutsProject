package com.mockproject.freetutsproject.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mockproject.freetutsproject.entity.PostEntity;

public class CommentDTO extends AbstractDTO<CommentDTO> {
	private String commenterName;
	private String commenterEmail;
	private Date date;
	private String comment;
	private PostEntity post;
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(String commenterName, String commenterEmail, Date date, String comment, PostEntity post) {
		super();
		this.commenterName = commenterName;
		this.commenterEmail = commenterEmail;
		this.date = date;
		this.comment = comment;
		this.post = post;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public String getCommenterEmail() {
		return commenterEmail;
	}

	public void setCommenterEmail(String commenterEmail) {
		this.commenterEmail = commenterEmail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}
	
}