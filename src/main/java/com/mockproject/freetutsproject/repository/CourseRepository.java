package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{

}
