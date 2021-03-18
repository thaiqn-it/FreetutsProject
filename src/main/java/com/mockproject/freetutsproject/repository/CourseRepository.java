package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.CourseEntity;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	List<CourseEntity> findByCategory(CategoryEntity category);
	List<CourseEntity> findTop5ByOrderByIdDesc();
}
