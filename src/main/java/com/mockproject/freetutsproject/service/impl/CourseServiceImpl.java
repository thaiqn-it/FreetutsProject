package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.CourseDTO;
import com.mockproject.freetutsproject.entity.CourseEntity;
import com.mockproject.freetutsproject.mapper.CourseMapper;
import com.mockproject.freetutsproject.repository.CourseRepository;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.util.FileUtil;
import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import com.mockproject.freetutsproject.util.StringUtil;
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
	private MultiLevelCategoryUtil multiLevelCategoryUtil;

	@Autowired
	private FileUtil fileUtil;

	@Autowired
	private StringUtil stringUtil;


	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseMapper courseMapper;

	@Override
	@Transactional (readOnly = true)
	public CourseDTO findById(Long id) {
		CourseEntity entity = courseRepository.findById(id).orElse(null);
		
		if (entity != null) {
			return courseMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
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
	@Transactional (readOnly = true)
	public List<CourseDTO> findAll() {
		// TODO Auto-generated method stub
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
}
