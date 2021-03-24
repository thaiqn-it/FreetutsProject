package com.mockproject.freetutsproject.dto;

import lombok.Data;

@Data
public class AbstractDTO<T> {
	private Long id;
	private boolean available;

	//for paging
	private int totalItems;
	private int totalPage;
	private int page;
	private int limit;
}
