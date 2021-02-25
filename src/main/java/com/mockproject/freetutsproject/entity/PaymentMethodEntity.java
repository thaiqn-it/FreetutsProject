package com.mockproject.freetutsproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity (name = "PaymentMethodTbl")
public class PaymentMethodEntity extends BaseEntity {
	
	@Column 
	private String name;
	
	@OneToMany (mappedBy = "paymentMethod")
	private List<OrderEntity> listOrder = new ArrayList<OrderEntity>();

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
	 * @return the listOrder
	 */
	public List<OrderEntity> getListOrder() {
		return listOrder;
	}

	/**
	 * @param listOrder the listOrder to set
	 */
	public void setListOrder(List<OrderEntity> listOrder) {
		this.listOrder = listOrder;
	}
}
