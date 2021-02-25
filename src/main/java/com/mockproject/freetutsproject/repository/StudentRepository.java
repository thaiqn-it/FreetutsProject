package com.mockproject.freetutsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.freetutsproject.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
