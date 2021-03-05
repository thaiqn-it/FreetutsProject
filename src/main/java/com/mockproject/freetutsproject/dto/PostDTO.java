package com.mockproject.freetutsproject.dto;

import java.util.Date;
import java.util.List;

import com.mockproject.freetutsproject.entity.AdminEntity;
import com.mockproject.freetutsproject.entity.CategoryEntity;

public class PostDTO extends AbstractDTO<PostDTO> {
	// Add more fields which use to show on frontend
	private String name;
	private String description;
	private Date createdDate;
	private String thumbnail;
	private AdminEntity creator;
	private CategoryEntity category;
	
	private List<ContentDTO> contents;
	private List<CommentDTO> comments;
	public PostDTO() {
		super();
	}
	public PostDTO(String name, String description, Date createdDate, String thumbnail, AdminEntity creator,
			CategoryEntity category, List<ContentDTO> contents, List<CommentDTO> comments) {
		super();
		this.name = name;
		this.description = description;
		this.createdDate = createdDate;
		this.thumbnail = thumbnail;
		this.creator = creator;
		this.category = category;
		this.contents = contents;
		this.comments = comments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public AdminEntity getCreator() {
		return creator;
	}
	public void setCreator(AdminEntity creator) {
		this.creator = creator;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public List<ContentDTO> getContents() {
		return contents;
	}
	public void setContents(List<ContentDTO> contents) {
		this.contents = contents;
	}
	public List<CommentDTO> getComments() {
		return comments;
	}
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	
}