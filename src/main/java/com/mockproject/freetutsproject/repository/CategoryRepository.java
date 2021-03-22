package com.mockproject.freetutsproject.repository;

import com.mockproject.freetutsproject.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	List<CategoryEntity> findByParentIsNull();
	CategoryEntity findOneByName(String name);
	List<CategoryEntity> findBySubCategoriesIsNull();
}
