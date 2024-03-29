package com.mockproject.freetutsproject.dto;

import lombok.Data;

@Data
public class OrderDTO extends AbstractDTO<OrderDTO> {
	// Add more fields which use to show on frontend
    private Long paymentMethod;

    private String name;

    private String phone;

    private String email;

    private String facebook;

    private float price;

    private String address;

    private Long courseId;
}