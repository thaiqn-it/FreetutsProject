package com.mockproject.freetutsproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByCategory(CategoryEntity category);
	PostEntity findByName(String name);
}
