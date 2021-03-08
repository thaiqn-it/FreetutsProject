package com.mockproject.freetutsproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.ContentDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.mapper.PostMapper;
import com.mockproject.freetutsproject.repository.PostRepository;
import com.mockproject.freetutsproject.service.CommentService;
import com.mockproject.freetutsproject.service.ContentService;
import com.mockproject.freetutsproject.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ContentService contentService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostMapper postMapper;
	
	public PostDTO loadPostInfo(String name) {
		//1.Post
		PostDTO result = new PostDTO();
		PostEntity entity = this.postRepository.findByName(name);
			//Entity -> DTO
			result = postMapper.toDTO(entity);
			
		//2.Contents
		List<ContentDTO> contents = this.contentService.loadContentsByPost(entity);
			//Add contents
		result.setContents(contents);
		
		//3.Comments
		List<CommentDTO> comments = this.commentService.loadCommentsByPost(entity);
			//Add comments
		result.setComments(comments);
		
		return result;
	}
}
