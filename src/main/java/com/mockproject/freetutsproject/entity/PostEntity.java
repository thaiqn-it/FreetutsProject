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

import lombok.Data;

@Data
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
	
	@Column
	private String contentFile;
	
	@ManyToOne
	@JoinColumn (name = "created_by")
	private AdminEntity creator;
	
	@ManyToOne
	@JoinColumn (name = "category")
	private CategoryEntity category;
	
	@OneToMany (mappedBy = "post")
	@LazyCollection(LazyCollectionOption.FALSE)	
	private List<CommentEntity> comments = new ArrayList<CommentEntity>();
}