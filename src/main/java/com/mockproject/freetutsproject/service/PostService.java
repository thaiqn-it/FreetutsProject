package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;

import java.io.IOException;
import java.util.List;

public interface PostService extends AbstractService<PostDTO> {
	List<PostDTO> findPostByCategoryAndAvailableTrue(CategoryDTO category);
	List<PostDTO> findPostByCategory(CategoryDTO category);
	List<PostDTO> findPostByCategoryAndOrderedById(CategoryDTO categoryDTO, int limit);
	List<PostDTO> findTop20PostByCategoryNameContainingOrderById(String name);
	List<PostDTO> findTop8PostByOrderById();
	PostDTO updateStatus(boolean status, long id);
	List<PostDTO> findTop15PostByCategories(List<CategoryDTO> categories);
	PostDTO findByIdAndAvailableTrue(Long id);
    boolean availableById(Long postId);
    PostDTO update(PostDTO dto)  throws IOException;
}
