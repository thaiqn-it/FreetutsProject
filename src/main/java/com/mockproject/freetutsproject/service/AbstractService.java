package com.mockproject.freetutsproject.service;

import java.util.List;

public interface AbstractService<T> {
	List<T> findAll();
	T findById(Long id);
	T save(T t);
}
