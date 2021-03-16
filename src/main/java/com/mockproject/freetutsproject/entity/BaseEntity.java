package com.mockproject.freetutsproject.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (columnDefinition = "bit default 1")
	private boolean available;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	
}
