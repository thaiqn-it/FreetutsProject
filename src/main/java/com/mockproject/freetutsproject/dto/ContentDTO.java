package com.mockproject.freetutsproject.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mockproject.freetutsproject.entity.PostEntity;

public class ContentDTO extends AbstractDTO<ContentDTO> {
	private String contentFile;
	private String name;
	private PostEntity post;
	public ContentDTO() {
		super();
	}
	public ContentDTO(String contentFile, String name, PostEntity post) {
		super();
		this.contentFile = contentFile;
		this.name = name;
		this.post = post;
	}
	public String getContentFile() {
		return contentFile;
	}
	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PostEntity getPost() {
		return post;
	}
	public void setPost(PostEntity post) {
		this.post = post;
	}
	
	
}