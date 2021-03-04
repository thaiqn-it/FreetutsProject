package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.CourseEntity;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
    List<CourseEntity> findCourseEntitiesByCategory();


}
