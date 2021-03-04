package com.mockproject.freetutsproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "comments")
public class CommentEntity extends BaseEntity {
	
	@Column (columnDefinition = "nvarchar(50)")
	private String commenterName;
	
	@Column
	private String commenterEmail;
	
	@Column
	private Date date;
	
	@Column (columnDefinition = "ntext")
	private String comment;

	@ManyToOne
	@JoinColumn (name = "post_id")
	private PostEntity post;


	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * @return the commenterName
	 */
	public String getCommenterName() {
		return commenterName;
	}

	/**
	 * @param name the name to set
	 */
	public void setCommenterName(String name) {
		this.commenterName = name;
	}

	/**
	 * @return the commenterEmail
	 */
	public String getCommenterEmail() {
		return commenterEmail;
	}

	/**
	 * @param email the email to set
	 */
	public void setCommenterEmail(String email) {
		this.commenterEmail = email;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the post
	 */
	public PostEntity getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(PostEntity post) {
		this.post = post;
	}
	
	
}
