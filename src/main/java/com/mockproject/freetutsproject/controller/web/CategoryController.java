package com.mockproject.freetutsproject.controller.web;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.PostService;
import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import com.mockproject.freetutsproject.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller (value = "categoryControllerOfWeb")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MultiLevelCategoryUtil categoryUtil;

	@Autowired
	private PostService postService;
	
	@GetMapping (value = "/category/{id}")
	public String viewCategory(@PathVariable("id") String id, Model model,
								@RequestParam(value="page", required = false, defaultValue = "1") int page, 
								@RequestParam(value="limit", required = false, defaultValue = "5") int limit) {
		CategoryDTO dto = categoryService.findById(Long.parseLong(id));

		if (dto != null) {
			processPagingOnPostListOfCategory(page, limit, dto);
			model.addAttribute("category", dto);
			setOtherDataOfCategoryPage(dto, model);
		}
		return "web/category";
	}
	


	private void setOtherDataOfCategoryPage(CategoryDTO dto, Model model) {
		List<CategoryDTO> categoryStack = categoryUtil.getCategoryListBottomUp(dto);
		
		// If post belong to "Lập trình" category
		if (categoryUtil.isBelongToLapTrinh(categoryStack)) {
			// Remove "Lập trình" since it not accessible
			categoryStack.remove(0);
			
			// Add breadcrumb data
			model.addAttribute("BREADCRUMB", categoryStack);
		}
		else {
			model.addAttribute("SUB_CATEGORY_BAR", getSubCategoryNavigationBar(dto));
		}
		
		// Divide subcategories into has children (not last level) and last level subcategories
		seperateSubCategoriesTo2Types(dto, model);
		
		// Add post if not last level category
		if (!dto.getName().equals("Programming")) {
			if (dto.getPosts().isEmpty()) {
				List<CategoryDTO> lastLevelCategoryDTOs = categoryUtil.findAllLastLevelSubCategroies(dto);
				dto.setPosts(postService.findTop15PostByCategories(lastLevelCategoryDTOs));
			}
		}
	}
	
	private List<CategoryDTO> getSubCategoryNavigationBar(CategoryDTO dto) {
		List<CategoryDTO> categoryStack;
		// Last level category
		if (dto.getSubCategories().isEmpty()) {
			CategoryDTO parent = categoryService.findById(dto.getParentId());
			categoryStack = categoryUtil.findAllLastLevelSubCategroies(parent);
		}
		
		//not last level category
		else {
			categoryStack = categoryUtil.findAllLastLevelSubCategroies(dto);
		}
		return categoryStack;
	}
	
	private void seperateSubCategoriesTo2Types(CategoryDTO dto, Model model) {
		List<CategoryDTO> listSubCateHasChildren = new ArrayList<>();
		List<CategoryDTO> listSubCateLastLevel = new ArrayList<>();
		if (dto.getSubCategories() != null) {
			dto.getSubCategories().forEach(subCategory -> {
				if (subCategory.getSubCategories().isEmpty()) {
					listSubCateLastLevel.add(subCategory);
				}
				else {
					listSubCateHasChildren.add(subCategory);
				}
			});
		}
		model.addAttribute("listSubCateHasChildren", listSubCateHasChildren);
		model.addAttribute("listSubCateLastLevel", listSubCateLastLevel);
	}
	
	private void processPagingOnPostListOfCategory(int page, int limit, CategoryDTO dto) {
		// Paging for post list
		dto.setPage(page);
		dto.setLimit(limit);
		dto.setTotalItems(dto.getPosts().size());
		dto.setTotalPage((int) Math.ceil((double) dto.getTotalItems() / dto.getLimit()));
		
		if (dto.getTotalItems() > 0) {
			List<PostDTO> pagedPostList = new PagingUtil<PostDTO>()
										.paging(dto.getPosts(), limit, page, dto.getTotalItems());
			dto.setPosts(pagedPostList);
		}
	}
}
