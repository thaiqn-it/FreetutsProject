package com.mockproject.freetutsproject.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "admins")
public class AdminEntity extends AbstractEntity {

	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column (columnDefinition = "nvarchar(50)")
	private String fullname;
	
	@OneToMany (mappedBy = "creator")
	private List<CategoryEntity> createdCategories = new ArrayList<CategoryEntity>();
	
	@OneToMany (mappedBy = "creator")
	private List<CourseEntity> createdCourses = new ArrayList<CourseEntity>();
	
	@OneToMany (mappedBy = "creator")
	private List<PostEntity> createdPosts = new ArrayList<PostEntity>();
}