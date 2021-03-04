package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> loadCourses();
}
