package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity (name = "OrderTbl")
public class OrderEntity extends BaseEntity {
	
	@ManyToOne
	@JoinColumn (name = "payment_method")
	private PaymentMethodEntity paymentMethod;
	
	@ManyToOne
	@JoinColumn (name = "student")
	private StudentEntity student;
	
	@ManyToMany 
	@JoinTable (name = "OrderDetailTbl", 
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
	 * @return the student
	 */
	public StudentEntity getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(StudentEntity student) {
		this.student = student;
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
	
	
}
