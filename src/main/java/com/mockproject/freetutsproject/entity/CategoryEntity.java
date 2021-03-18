package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Data
@Entity
@Table (name = "category")
public class CategoryEntity extends BaseEntity {
	
	@Column(columnDefinition="nvarchar(50)")
	private String name;
	
	@Column
	private String thumbnail;
	
	@Column (columnDefinition = "ntext")
	private String description;
	
	@ManyToOne
	@JoinColumn (name = "parent_id")
	private CategoryEntity parent;
	
	@OneToMany (mappedBy = "parent")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CategoryEntity> subCategories = new ArrayList<CategoryEntity>();
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "created_by")
	private AdminEntity creator;
	
	@OneToMany (mappedBy = "category")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CourseEntity> courses = new ArrayList<CourseEntity>();

	@OneToMany (mappedBy = "category")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PostEntity> posts = new ArrayList<PostEntity>();
}