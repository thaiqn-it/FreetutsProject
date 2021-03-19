package com.mockproject.freetutsproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "comments")
public class CommentEntity extends AbstractEntity {
	
	@Column (columnDefinition = "nvarchar(50)")
	private String commenterName;
	
	@Column
	private String commenterEmail;
	
	@Column
	private Date date;
	
	@Column (columnDefinition = "ntext")
	private String comment;

	@ManyToOne
	@JoinColumn (name = "post_id")
	private PostEntity post;
	
	@ManyToOne
	@JoinColumn (name = "course_id")
	private CourseEntity course;
}