package com.mockproject.freetutsproject.interceptor;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.dto.DiscountDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.service.DiscountService;
import com.mockproject.freetutsproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class LayoutPreloadInterceptor implements HandlerInterceptor{
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private DiscountService discountService;

	@Autowired
	private PostService postService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// Wont load anything if user access admin page
		if (!request.getServletPath().contains("/admin")) {
			// Load Header Navigation Category
			List<CategoryDTO> categories = categoryService.loadTopLevelCategories();
			request.setAttribute("CATEGORIES", categories);

			// Load footer
			// 1. Discount
			CategoryDTO discountCategory = categoryService.findCategory("Mã giảm giá");
			request.setAttribute("DISCOUNT_POSTS", discountCategory.getSubCategories());

			//2. Load 5 newest courses
			List<CourseDTO> courses = courseService.findTopFiveNewestCourse();
			request.setAttribute("COURSES", courses);

			// Load Discount code widget
			List<DiscountDTO> discounts = discountService.findAllAndAvailableTrue();
			request.setAttribute("DISCOUNT_CODES", discounts);

			// Load view more frame
			List<PostDTO> viewMorePost = postService.findTop8PostByOrderById();
			;
			request.setAttribute("VIEW_MORE", viewMorePost);
		}

		return true;
	}
	
	
	
}

