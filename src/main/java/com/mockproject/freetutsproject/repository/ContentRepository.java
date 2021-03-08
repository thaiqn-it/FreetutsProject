package com.mockproject.freetutsproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.ContentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

public interface ContentRepository extends JpaRepository<ContentEntity, Long> {
	List<ContentEntity> findByPost(PostEntity post);
}
