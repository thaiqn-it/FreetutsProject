package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
