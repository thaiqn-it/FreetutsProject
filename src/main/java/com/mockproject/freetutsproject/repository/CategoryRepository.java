package com.mockproject.freetutsproject.repository;

import java.util.List;

import com.mockproject.freetutsproject.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	List<CategoryEntity> findByParentIsNullAndAvailableTrue();
	CategoryEntity findOneByName(String name);
	List<CategoryEntity> findBySubCategoriesIsNullAndAvailableTrue();
	CategoryEntity findByIdAndAvailableTrue(Long id);
	List<CategoryEntity> findByParentId(long id);
	List<CategoryEntity> findByParentIdAndAvailableTrue(long id);

}
