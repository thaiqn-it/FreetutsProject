package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>{
}