package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
