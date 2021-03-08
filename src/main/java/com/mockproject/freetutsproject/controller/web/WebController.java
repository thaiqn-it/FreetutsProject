package com.mockproject.freetutsproject.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.PostService;
import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import com.mockproject.freetutsproject.util.PagingUtil;

@Controller
public class WebController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MultiLevelCategoryUtil categoryUtil;
	
	@Autowired
	private PostService postService;

	@RequestMapping(value = "post/{name}", method = RequestMethod.GET)
	public String loadPost(@PathVariable("name") String name, Model model) {
		// Get post
		PostDTO postDTO = this.postService.loadPostInfo(name);
		model.addAttribute("post", postDTO);
		
		// Get breadcrumb data 
		long id = postDTO.getCategoryId();
		CategoryDTO dto = categoryService.findCategory(id);
		List<CategoryDTO> categoryBreadcrumb = categoryUtil.getCategoryListBottomUp(dto);
		model.addAttribute("breadcrumb", categoryBreadcrumb);
		
		return "post";
	}
	
	@GetMapping (value = "/category/{id}")
	public String viewCategory(@PathVariable("id") String id, Model model,
								@RequestParam("page") int page, 
								@RequestParam("limit") int limit) {
		CategoryDTO dto = categoryService.findCategory(Long.parseLong(id));
		
		
		List<CategoryDTO> categoryBreadcrumb = categoryUtil.getCategoryListBottomUp(dto);
		model.addAttribute("breadcrumb", categoryBreadcrumb);
		
		// Divide subcategories into has children (not last level) and last level subcategories
		List<CategoryDTO> listSubCateHasChildren = new ArrayList<CategoryDTO>();
		List<CategoryDTO> listSubCateLastLevel = new ArrayList<CategoryDTO>();
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
		
		model.addAttribute("category", dto);
		return "category";
	}

}
