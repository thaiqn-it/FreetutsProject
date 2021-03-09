package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.CourseDTO;

public interface CourseService {
    CourseDTO findCourseById(Long id);
}
