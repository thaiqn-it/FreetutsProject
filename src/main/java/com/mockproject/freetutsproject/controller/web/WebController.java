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
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CourseService;
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
	
	@Autowired
	private CourseService courseService;

	@GetMapping(value = "post/{name}")
	public String loadPost(@PathVariable("name") String name, Model model) {
		// Get post
		PostDTO postDTO = this.postService.loadPostInfo(name);
		
		if (postDTO != null) {
			model.addAttribute("post", postDTO);
			
			long id = postDTO.getCategoryId();
			CategoryDTO dto = categoryService.findCategory(id);
			
			// Get breadcrumb data 
			List<CategoryDTO> categoryBreadcrumb = categoryUtil.getCategoryListBottomUp(dto);
			model.addAttribute("breadcrumb", categoryBreadcrumb);
			
			// Get relate post
			List<PostDTO> relatePosts = postService.findPostByCategory(dto);
			model.addAttribute("relatePosts", relatePosts);
		}
		return "post";
	}
	
	@GetMapping (value = "/category/{id}")
	public String viewCategory(@PathVariable("id") String id, Model model,
								@RequestParam(value="page", required = false, defaultValue = "1") int page, 
								@RequestParam(value="limit", required = false, defaultValue = "5") int limit) {
		CategoryDTO dto = categoryService.findCategory(Long.parseLong(id));
		
		if (dto != null) {
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
		}
		return "category";
	}
	
	@GetMapping(value = "/course/{id}")
	public String viewCourse(@PathVariable("id") String id, Model model) {
		CourseDTO dto = courseService.findCourseById(Long.parseLong(id));
		model.addAttribute("course", dto);
		
		if (dto != null) {
			long categoryId = dto.getCategoryId();
			CategoryDTO category = categoryService.findCategory(categoryId);
			
			// Get breadcrumb data 
			List<CategoryDTO> categoryBreadcrumb = categoryUtil.getCategoryListBottomUp(category);
			model.addAttribute("breadcrumb", categoryBreadcrumb);

		}
		return "course";
	}
}
