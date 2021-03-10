package com.mockproject.freetutsproject.dto;

import java.util.Date;
import java.util.List;
public class PostDTO extends AbstractDTO<PostDTO> {

	// Add more fields which use to show on frontend
	private String name;
	private String description;
	private Date createdDate;
	private String thumbnail;
	private AdminDTO creator;
	private Long categoryId;	
	private String contentFile ;
	private List<CommentDTO> comments;
	
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	/**
	 * @return the creator
	 */
	public AdminDTO getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(AdminDTO creator) {
		this.creator = creator;
	}
	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * @return the comments
	 */
	public List<CommentDTO> getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	
}