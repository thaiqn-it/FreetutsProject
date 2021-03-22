package com.mockproject.freetutsproject.entity;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table (name = "courses")
public class CourseEntity extends AbstractEntity{
	
	@Column(columnDefinition = "nvarchar(255)")
	private String name;
	
	@Column(columnDefinition = "ntext")
	private String description;
	
	@Column
	private String thumbnail;
	
	@Column
	private String learnMethod;
	
	@Column
	private String courseLink;
	
	@Column
	private Long price;
	
	@Column
	@CreatedDate
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn (name = "created_by")
	@CreatedBy
	private AdminEntity creator;
	
	@ManyToOne
	@JoinColumn (name = "category")
	private CategoryEntity category;
	
	@ManyToMany (mappedBy = "courses")
	private List<OrderEntity> orders = new ArrayList<OrderEntity>();
	
	@OneToMany (mappedBy = "course")
	@Where(clause = "available = true")
	private List<CommentEntity> comments = new ArrayList<CommentEntity>();
}