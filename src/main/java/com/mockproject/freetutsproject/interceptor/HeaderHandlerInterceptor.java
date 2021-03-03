package com.mockproject.freetutsproject.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.service.CategoryService;

@Component
public class HeaderHandlerInterceptor implements HandlerInterceptor{
	@Autowired
	private CategoryService categoryService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<CategoryDTO> categories = categoryService.loadCategories();
		request.setAttribute("CATEGORIES", categories);
		return true;
	}
	
	
	
}

