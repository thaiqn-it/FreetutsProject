package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> loadCategories();
}
