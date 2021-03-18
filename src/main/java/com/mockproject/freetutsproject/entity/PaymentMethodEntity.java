package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "paymentMethods")
public class PaymentMethodEntity extends BaseEntity {
	
	@Column (columnDefinition = "nvarchar(50)")
	private String name;
	
	@OneToMany (mappedBy = "paymentMethod")
	private List<OrderEntity> listOrder = new ArrayList<OrderEntity>();
}