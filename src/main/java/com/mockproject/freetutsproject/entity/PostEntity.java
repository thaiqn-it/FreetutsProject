package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table (name = "posts")
public class PostEntity extends BaseEntity {
	
	@Column (columnDefinition = "nvarchar(255)")
	private String name;
	
	@Column (columnDefinition = "ntext")
	private String description;
	
	@Column
	private Date createdDate;
	
	@Column
	private String thumbnail;
	
	@ManyToOne
	@JoinColumn (name = "created_by")
	private AdminEntity creator;
	
	@ManyToOne
	@JoinColumn (name = "category")
	private CategoryEntity category;
	
	@OneToMany (mappedBy = "post")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ContentEntity> contents = new ArrayList<ContentEntity>();
	
	@OneToMany (mappedBy = "post")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CommentEntity> comments = new ArrayList<CommentEntity>();

	/**
	 * @return the comments
	 */
	public List<CommentEntity> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
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
	public AdminEntity getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(AdminEntity creator) {
		this.creator = creator;
	}

	/**
	 * @return the category
	 */
	public CategoryEntity getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	/**
	 * @return the contents
	 */
	public List<ContentEntity> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<ContentEntity> contents) {
		this.contents = contents;
	}
}