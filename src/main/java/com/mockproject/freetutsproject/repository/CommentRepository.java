package com.mockproject.freetutsproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.CommentEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
	List<CommentEntity> findByPost(PostEntity post);
}
