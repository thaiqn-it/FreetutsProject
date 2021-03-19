package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CategoryDTO;

public interface CategoryService extends AbstractService<CategoryDTO> {
	List<CategoryDTO> loadTopLevelCategories();
	CategoryDTO findCategory(String name);
	List<CategoryDTO> findBySubCategoriesIsNull();
}
