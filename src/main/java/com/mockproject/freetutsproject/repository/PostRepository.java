package com.mockproject.freetutsproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByCategory(CategoryEntity category);

	@Query (value = "SELECT TOP (:limit) p.*  FROM posts p WHERE p.category IN :ids ORDER BY p.id DESC",
			nativeQuery = true)
	List<PostEntity> findPostByCategoriesAndOrderedByIdLimitedTo(@Param("ids") List<Long> ids, @Param("limit") int limit);

	PostEntity findByName(String name);

	List<PostEntity> findTop20PostByCategoryNameContainingOrderById(String name);
}
