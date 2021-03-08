package com.mockproject.freetutsproject.dto;

public class ContentDTO extends AbstractDTO<ContentDTO> {
	private String contentFile;
	private String name;
	private PostDTO post;
	public ContentDTO() {
		super();
	}
	public ContentDTO(String contentFile, String name, PostDTO post) {
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
	public PostDTO getPost() {
		return post;
	}
	public void setPost(PostDTO post) {
		this.post = post;
	}
	
	
}