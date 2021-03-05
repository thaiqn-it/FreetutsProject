package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.PostDTO;

public interface PostService {
	PostDTO loadPostInfo(String name);
}
