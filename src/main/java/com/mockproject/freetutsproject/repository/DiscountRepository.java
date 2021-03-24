package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.DiscountEntity;

import java.util.List;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Long>{
    List<DiscountEntity> findAllByAvailableTrue();
    boolean existsByDiscountCode(String code);
}
