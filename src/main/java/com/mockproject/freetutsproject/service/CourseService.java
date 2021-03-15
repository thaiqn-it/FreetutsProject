package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CourseDTO;

public interface CourseService {
    CourseDTO findCourseById(Long id);
    List<CourseDTO> findTopFiveNewestCourse();
}
