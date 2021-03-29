package com.mockproject.freetutsproject.util;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MultiLevelCategoryUtil {
	
	@Autowired
	private CategoryService categoryService;
	
	public List<CategoryDTO> findAllLastLevelSubCategroies(CategoryDTO dto){
		// Load all categories in one "family" to 2 list: 
		// has child category list and doesn't have child (last level) category list
		// "family": hierachy based on 1 first level category
		List<CategoryDTO> hasChildCategory = new ArrayList<CategoryDTO>();
		List<CategoryDTO> lastLevelCategory = new ArrayList<CategoryDTO>();
		hasChildCategory.add(dto);
		
		for (int i = 0; i < hasChildCategory.size(); i++) {
			hasChildCategory.get(i).getSubCategories().forEach(subCate -> {
				if (subCate.getSubCategories().isEmpty()) {
					lastLevelCategory.add(subCate);
				}
				else {
					hasChildCategory.add(subCate);
				}
			});
		}
		
		return lastLevelCategory;
	}
	
	public List<CategoryDTO> getCategoryListBottomUp(CategoryDTO lastLevelCategory){
		List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
		categoryList.add(lastLevelCategory);
		
		for (int i = 0; i < categoryList.size(); i++) {
			CategoryDTO item = categoryList.get(i);
			Long parentId = item.getParentId();
			if (parentId != null) {
				categoryList.add(categoryService.findById(parentId));
			}
		}
		Collections.reverse(categoryList);
		
		return categoryList;
	}

	public boolean isBelongToLapTrinh(List<CategoryDTO> categoryStack) {
		return categoryStack.get(0).getName().equals("Lập trình");
	}
}
