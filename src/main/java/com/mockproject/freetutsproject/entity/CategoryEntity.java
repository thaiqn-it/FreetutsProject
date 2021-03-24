package com.mockproject.freetutsproject.entity;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table (name = "category")
public class CategoryEntity extends AbstractEntity {
	
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
	@Where(clause = "available = true")
	private List<CategoryEntity> subCategories = new ArrayList<CategoryEntity>();
	
	@ManyToOne
	@JoinColumn (name = "created_by")
	@CreatedBy
	private AdminEntity creator;
	
	@OneToMany (mappedBy = "category")
	@Where(clause = "available = true")
	private List<CourseEntity> courses = new ArrayList<CourseEntity>();

	@OneToMany (mappedBy = "category")
	@Where(clause = "available = true")
	private List<PostEntity> posts = new ArrayList<PostEntity>();
}