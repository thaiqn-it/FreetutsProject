package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.entity.PostEntity;

public interface CommentService extends AbstractService<CommentDTO>{
	CommentDTO save(CommentDTO dto);
}
