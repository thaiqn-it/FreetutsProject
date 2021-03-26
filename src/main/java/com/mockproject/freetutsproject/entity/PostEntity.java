package com.mockproject.freetutsproject.entity;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table (name = "posts")
public class PostEntity extends AbstractEntity {
	
	@Column (columnDefinition = "nvarchar(255)")
	private String name;
	
	@Column (columnDefinition = "ntext")
	private String description;
	
	@Column
	@CreatedDate
	private Date createdDate;
	
	@Column
	private String thumbnail;
	
	@Column
	private String contentFile;

//	@CreatedBy
	@ManyToOne
	@JoinColumn (name = "created_by")
	private AdminEntity creator;
	
	@ManyToOne
	@JoinColumn (name = "category")
	private CategoryEntity category;
	
	@OneToMany (mappedBy = "post")
	@Where(clause = "available = true")
	private List<CommentEntity> comments = new ArrayList<CommentEntity>();
}