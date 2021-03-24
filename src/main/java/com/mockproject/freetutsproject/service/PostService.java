package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;

public interface PostService extends AbstractService<PostDTO> {
	List<PostDTO> findPostByCategory(CategoryDTO category);
	List<PostDTO> findPostByCategoryAndOrderedById(CategoryDTO categoryDTO, int limit);
	List<PostDTO> findTop20PostByCategoryNameContainingOrderById(String name);
	List<PostDTO> findTop8PostByOrderById();
	void updateStatus(boolean status, PostDTO dto);
}
