package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.CourseEntity;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	List<CourseEntity> findByCategory(CategoryEntity category);
	
	@Query(value = "SELECT TOP 5 c.* FROM courses c ORDER BY c.id DESC", nativeQuery = true)
	List<CourseEntity>  findTopFiveCoursesOrderByIdDescending();
}
