package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.mapper.CourseMapper;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public CourseDTO findById(Long id) {
        CourseEntity entity = courseRepository.findById(id).orElse(null);

        if (entity != null) {
            return courseMapper.toDTO(entity);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDTO> findTopFiveNewestCourse() {
        List<CourseEntity> entities = courseRepository.findTop5ByAvailableTrueOrderByIdDesc();

        if (entities != null) {
            List<CourseDTO> dtos = new ArrayList<CourseDTO>();
            entities.forEach(entity -> {
                dtos.add(courseMapper.toDTO(entity));
            });

            return dtos;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDTO> findAll() {
        List<CourseEntity> entities = courseRepository.findAll();

        if (!entities.isEmpty()) {
            List<CourseDTO> DTOs = new ArrayList<CourseDTO>();
            entities.forEach(entity -> DTOs.add(courseMapper.toDTO(entity)));
            return DTOs;
        }
        return null;
    }

    @Override
    @Transactional
    public CourseDTO save(CourseDTO courseDTO) {
        String imageName = null;
        try {
            imageName = fileUtil.writeImageHardDisk(courseDTO.getImage());

            courseDTO.setThumbnail(imageName);

            CourseEntity entity = courseMapper.toEntity(courseDTO);
            return courseMapper.toDTO(courseRepository.save(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public CourseDTO updateStatus(boolean status, long id) {
        CourseEntity entity = courseRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setAvailable(status);
            return courseMapper.toDTO(courseRepository.save(entity));
        }
        return null;
    }

    @Override
    public List<CourseDTO> findCoursesByCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDTO);
        List<CourseEntity> entityList = courseRepository.findByCategory(categoryEntity);

        if (!entityList.isEmpty()) {
            List<CourseDTO> dtoList = new ArrayList<CourseDTO>();
            entityList.forEach(entity -> dtoList.add(courseMapper.toDTO(entity)));
            return dtoList;
        }
        return null;
    }

    @Override
    public boolean availableById(Long courseId) {
        return courseRepository.existsByIdAndAvailableTrue(courseId);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO dto) throws IOException {
        CourseEntity entity = courseRepository.findById(dto.getId()).orElse(null);
        if (entity != null){
            if (dto.getImage() != null){
                String imageName = fileUtil.writeImageHardDisk(dto.getImage());
                dto.setThumbnail(imageName);
            }
            courseMapper.toEntity(dto, entity);
            return courseMapper.toDTO(courseRepository.save(entity));
        }
        return null;
    }
}
