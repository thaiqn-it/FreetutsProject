package com.mockproject.freetutsproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "contents")
public class ContentEntity extends BaseEntity {
	
	@Column
	private String contentFile;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn (name = "post_id")
	private PostEntity post;

	/**
	 * @return the contentFile
	 */
	public String getContentFile() {
		return contentFile;
	}

	/**
	 * @param contentFile the contentFile to set
	 */
	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
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