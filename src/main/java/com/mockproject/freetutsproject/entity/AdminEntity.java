package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Data
@Entity
@Table (name = "admins")
public class AdminEntity extends BaseEntity {

	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column (columnDefinition = "nvarchar(50)")
	private String fullname;
	
	@OneToMany (mappedBy = "creator")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CategoryEntity> createdCategories = new ArrayList<CategoryEntity>();
	
	@OneToMany (mappedBy = "creator")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CourseEntity> createdCourses = new ArrayList<CourseEntity>();
	
	@OneToMany (mappedBy = "creator")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PostEntity> createdPosts = new ArrayList<PostEntity>();
}