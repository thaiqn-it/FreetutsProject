package com.mockproject.freetutsproject.service;

import java.util.List;

import com.mockproject.freetutsproject.dto.CourseDTO;

public interface CourseService extends AbstractService<CourseDTO>{
    List<CourseDTO> findTopFiveNewestCourse();
}
