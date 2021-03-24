package com.mockproject.freetutsproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class AbstractDTO<T> {
	private Long id;

	//for paging
	private int totalItems;
	private int totalPage;
	private int page;
	private int limit;

	private boolean available = true;
}
