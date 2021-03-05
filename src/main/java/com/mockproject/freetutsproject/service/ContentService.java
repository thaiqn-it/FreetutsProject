package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.ContentDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.PostEntity;

public interface ContentService {
	List<ContentDTO> loadContentsByPost(PostEntity post);
}
