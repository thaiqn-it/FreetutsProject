package com.mockproject.freetutsproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private boolean available = true;
}