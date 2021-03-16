package com.mockproject.freetutsproject.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CommentService;
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
	
	@Autowired 
	private CommentService commentService;

	@GetMapping(value = "post/{id}")
	public String loadPost(@PathVariable("id") String id, Model model) {
		// Get post
		PostDTO postDTO = this.postService.findById(Long.parseLong(id));
		
		if (postDTO != null) {
			model.addAttribute("post", postDTO);
			
			long categoryId = postDTO.getCategoryId();
			CategoryDTO dto = categoryService.findCategory(categoryId);
			
			// Get breadcrumb data 
			List<CategoryDTO> categoryBreadcrumb = categoryUtil.getCategoryListBottomUp(dto);
			model.addAttribute("BREADCRUMB", categoryBreadcrumb);
			
			// If post belong to "Lập trình" category
			if (categoryBreadcrumb.get(0).getName().equals("Lập trình")) {
				// Remove "Lập trình" since it not accessible
				categoryBreadcrumb.remove(0);
				
				// Get relate post
				List<PostDTO> relatePosts = postService.findPostByCategory(dto);
				model.addAttribute("RELATED_POSTS", relatePosts);
				
				// Alert flag
				model.addAttribute("BELONG_TO_PROGRAMMING", true);
			}
			
			// Comment object for comment form
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setPostId(postDTO.getId());
			model.addAttribute("comment", commentDTO);
		}
		return "post";
	}
	
	@GetMapping (value = "/category/{id}")
	public String viewCategory(@PathVariable("id") String id, Model model,
								@RequestParam(value="page", required = false, defaultValue = "1") int page, 
								@RequestParam(value="limit", required = false, defaultValue = "5") int limit) {
		CategoryDTO dto = categoryService.findCategory(Long.parseLong(id));
		
		if (dto != null) {
			List<CategoryDTO> categoryNaviagtionBar = categoryUtil.getCategoryListBottomUp(dto);
			
			// If post belong to "Lập trình" category
			if (categoryNaviagtionBar.get(0).getName().equals("Lập trình")) {
				// Remove "Lập trình" since it not accessible
				categoryNaviagtionBar.remove(0);
				
				// Add breadcrumb data
				model.addAttribute("BREADCRUMB", categoryNaviagtionBar);
			}
			else {
				// Last level category
				if (dto.getSubCategories().isEmpty()) {
					CategoryDTO parent = categoryService.findCategory(dto.getParentId()); 
					categoryNaviagtionBar = categoryUtil.findAllLastLevelSubCategroies(parent);
				}
				
				//not last level category
				else {
					categoryNaviagtionBar = categoryUtil.findAllLastLevelSubCategroies(dto);
				}
				model.addAttribute("SUB_CATEGORY_BAR", categoryNaviagtionBar);
				
			}
			
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
			
			// Comment object for comment form
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setCourseId(Long.parseLong(id));
			model.addAttribute("comment", commentDTO);

		}
		return "course";
	}
	
	@PostMapping(value = "/comment/")
	public String comment(CommentDTO commentDTO) {
		CommentDTO savedComment = commentService.save(commentDTO);
		if (savedComment.getCourseId() != null) {
			return "redirect:/course/" + savedComment.getCourseId();
		}
		else if (savedComment.getPostId() != null) {
			return "redirect:/post/" + savedComment.getPostId();
		}
		return "error-404";
	}
}
