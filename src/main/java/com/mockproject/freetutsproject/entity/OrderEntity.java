package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "orders")
public class OrderEntity extends BaseEntity {
	
	@ManyToOne
	@JoinColumn (name = "payment_method")
	private PaymentMethodEntity paymentMethod;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String name;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column
	private String facebook;

	@Column
	private float price;

	@Column(columnDefinition = "nvarchar(255)")
	private String address;
	
	@ManyToMany 
	@JoinTable (name = "orderDetails", 
				joinColumns = @JoinColumn(name = "order_id"), 
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<CourseEntity> courses = new ArrayList<CourseEntity>();
}