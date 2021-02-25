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
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private Date date;
	
	@ManyToOne
	@JoinColumn (name = "post_id")
	private PostEntity post;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
