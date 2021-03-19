package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
}