package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;

import java.util.List;

public interface CourseService extends AbstractService<CourseDTO>{
    List<CourseDTO> findTopFiveNewestCourse();
    CourseDTO updateStatus(boolean status, long id);
    List<CourseDTO> findCoursesByCategory(CategoryDTO categoryDTO);
    boolean availableById(Long courseId);
}
