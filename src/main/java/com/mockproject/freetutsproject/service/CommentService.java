package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.CommentDTO;

public interface CommentService extends AbstractService<CommentDTO>{
	CommentDTO save(CommentDTO dto);
}
