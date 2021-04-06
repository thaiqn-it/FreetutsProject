package com.mockproject.freetutsproject.repository;

import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByCategoryAndAvailableTrue(CategoryEntity category);
	PostEntity findByIdAndAvailableTrue(Long id);

	@Query (value = "SELECT p FROM PostEntity p WHERE p.category.id IN :ids AND available = 1 ORDER BY p.id DESC")
	Page<PostEntity> findPostByCategoriesAndOrderedByIdLimitedTo(@Param("ids") List<Long> ids, Pageable pageable);

	List<PostEntity> findTop20PostByAvailableTrueAndCategoryNameContainingOrderById(String name);

	List<PostEntity> findTop8PostByAvailableTrueOrderByIdDesc();
	
	List<PostEntity> findTop15PostByCategoryIdInOrderById(List<Long> categoryIds);

	List<PostEntity> findByCategory(CategoryEntity category);

	boolean existsByIdAndAvailableTrue(Long id);
}