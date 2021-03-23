package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CategoryDTO;

public interface CategoryService extends AbstractService<CategoryDTO> {
	List<CategoryDTO> loadCategories();
	CategoryDTO findCategory(String name);
	void updateStatus(Boolean status, CategoryDTO dto);
}
