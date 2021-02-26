package com.mockproject.freetutsproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.StudentRepository;
import com.mockproject.freetutsproject.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
}
