package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity (name = "AdminTbl")
public class AdminEntity extends BaseEntity {

	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String fullname;
	
	@OneToMany (mappedBy = "creator")
	private List<CategoryEntity> createdCategories = new ArrayList<CategoryEntity>();
	
	@OneToMany (mappedBy = "creator")
	private List<CourseEntity> createdCourses = new ArrayList<CourseEntity>();

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the createdCategories
	 */
	public List<CategoryEntity> getCreatedCategories() {
		return createdCategories;
	}

	/**
	 * @param createdCategories the createdCategories to set
	 */
	public void setCreatedCategories(List<CategoryEntity> createdCategories) {
		this.createdCategories = createdCategories;
	}

	/**
	 * @return the createdCourses
	 */
	public List<CourseEntity> getCreatedCourses() {
		return createdCourses;
	}

	/**
	 * @param createdCourses the createdCourses to set
	 */
	public void setCreatedCourses(List<CourseEntity> createdCourses) {
		this.createdCourses = createdCourses;
	}
	
	
}
