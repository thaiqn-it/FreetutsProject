package com.mockproject.freetutsproject.repository;

import com.mockproject.freetutsproject.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	List<CourseEntity> findTop5ByAvailableTrueOrderByIdDesc();
}
