package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
