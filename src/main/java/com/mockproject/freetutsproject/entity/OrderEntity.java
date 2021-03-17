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

	/**
	 * @return the paymentMethod
	 */
	public PaymentMethodEntity getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(PaymentMethodEntity paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the facebook
	 */
	public String getFacebook() {
		return facebook;
	}

	/**
	 * @param facebook the facebook to set
	 */
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	/**
	 * @return the courses
	 */
	public List<CourseEntity> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
