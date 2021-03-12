package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;

public interface PostService {
	List<PostDTO> findPostByCategory(CategoryDTO category);
	PostDTO loadPostInfo(String name);
	List<PostDTO> findPostByCategoryAndOrderedByIdLimitedTo(CategoryDTO categoryDTO, int limit);

}
