package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface CategoryService extends AbstractService<CategoryDTO> {
	List<CategoryDTO> loadTopLevelCategories();
	CategoryDTO findCategory(String name);
	CategoryDTO updateStatus(boolean status, long id);
	List<CategoryDTO> findBySubCategoriesIsNull();
	List<CategoryDTO> findByParentId(long id);
	CategoryDTO findByIdAndAvailableTrue(long id);
	CategoryDTO updateCategory(CategoryDTO dto) throws IOException;
}
