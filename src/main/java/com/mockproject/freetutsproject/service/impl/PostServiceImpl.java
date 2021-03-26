package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.AbstractDTO;
import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.entity.PostEntity;
import com.mockproject.freetutsproject.mapper.CategoryMapper;
import com.mockproject.freetutsproject.mapper.PostMapper;
import com.mockproject.freetutsproject.repository.PostRepository;
import com.mockproject.freetutsproject.service.PostService;
import com.mockproject.freetutsproject.util.FileUtil;
import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import com.mockproject.freetutsproject.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private MultiLevelCategoryUtil multiLevelCategoryUtil;

	@Autowired
	private FileUtil fileUtil;

	@Autowired
	private StringUtil stringUtil;

	@Override
	@Transactional(readOnly = true)
	public PostDTO findByIdAndAvailableTrue(Long id){
		PostEntity entity = this.postRepository.findByIdAndAvailableTrue(id);
		if (entity != null) {
			return postMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<PostDTO> findTop8PostByOrderById() {
		List<PostEntity> entity = postRepository.findTop8PostByAvailableTrueOrderByIdDesc();
		if(!entity.isEmpty()){
			List<PostDTO> postDTOList = new ArrayList<>();
			entity.forEach(postEntity -> postDTOList.add(postMapper.toDTO(postEntity)));
			return postDTOList;
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<PostDTO> findPostByCategoryAndOrderedById(CategoryDTO categoryDTO, int limit) {
		if (!categoryDTO.getPosts().isEmpty()) {
			List<PostDTO> originalPostList = categoryDTO.getPosts();
			List<PostDTO> postDTOList = new ArrayList<>();
			Collections.reverse(originalPostList);
			for (int i = 0; i < limit; i++) {
				postDTOList.add(originalPostList.get(i));
			}
			return postDTOList;
		}

		List<PostEntity> postEntityList;
		List<CategoryDTO> lastLevelCategories = multiLevelCategoryUtil.findAllLastLevelSubCategroies(categoryDTO);
		List<Long> ids = new ArrayList<>();
		lastLevelCategories.forEach(category -> ids.add(category.getId()));
		postEntityList = postRepository.findPostByCategoriesAndOrderedByIdLimitedTo(ids, 5);
		if (!postEntityList.isEmpty()) {
			List<PostDTO> postDTOList = new ArrayList<PostDTO>();
			postEntityList.forEach(entity -> postDTOList.add(postMapper.toDTO(entity)));
			return postDTOList;
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PostDTO> findTop20PostByCategoryNameContainingOrderById(String name) {
		List<PostEntity> entities = postRepository.findTop20PostByAvailableTrueAndCategoryNameContainingOrderById(name);
		if(!entities.isEmpty()){
			List<PostDTO> postDTOList = new ArrayList<>();
			entities.forEach(postEntity -> postDTOList.add(postMapper.toDTO(postEntity)));
			return postDTOList;
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PostDTO> findPostByCategoryAndAvailableTrue(CategoryDTO category) {
		CategoryEntity categoryEntity = categoryMapper.toEntity(category);
		List<PostEntity> entityList = postRepository.findByCategoryAndAvailableTrue(categoryEntity);
		
		if (!entityList.isEmpty()) {
			List<PostDTO> dtoList = new ArrayList<PostDTO>();
			entityList.forEach(entity -> dtoList.add(postMapper.toDTO(entity)));
			return dtoList;
		}

		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<PostDTO> findPostByCategory(CategoryDTO category) {
		CategoryEntity categoryEntity = categoryMapper.toEntity(category);
		List<PostEntity> entityList = postRepository.findByCategory(categoryEntity);

		if (!entityList.isEmpty()) {
			List<PostDTO> dtoList = new ArrayList<PostDTO>();
			entityList.forEach(entity -> dtoList.add(postMapper.toDTO(entity)));
			return dtoList;
		}

		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PostDTO> findAll() {
		List<PostEntity> entities = postRepository.findAll();

		if (!entities.isEmpty()) {
			List<PostDTO> DTOs = new ArrayList<PostDTO>();
			entities.forEach(entity -> DTOs.add(postMapper.toDTO(entity)));
			return DTOs;
		}
		return null;
	}

	@Override
	public PostDTO findById(Long id) {
		PostEntity entity = postRepository.findById(id).orElse(null);
		if (entity != null){
			return postMapper.toDTO(entity);
		}
		return null;
	}

	@Override
	@Transactional
	public PostDTO save(PostDTO postDTO) {
		String fileName = null;
		String imageName = null;
		try {
			fileName = fileUtil.writeContentToHTMLOnHardDisk(postDTO.getContentFile(), stringUtil.removeAccent(postDTO.getName()));
			imageName = fileUtil.writeImageHardDisk(postDTO.getImage());

			postDTO.setContentFile(fileName);
			postDTO.setThumbnail(imageName);

			PostEntity entity = postMapper.toEntity(postDTO);
			return postMapper.toDTO(postRepository.save(entity));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional (readOnly = true)
	public List<PostDTO> findTop15PostByCategories(List<CategoryDTO> categories) {
		List<Long> categoryIds = categories.stream()
											.map(AbstractDTO::getId)
											.collect(Collectors.toList());
		
		List<PostEntity> postEntities = postRepository.findTop15PostByCategoryIdInOrderById(categoryIds);
		if (!postEntities.isEmpty()) {
			return postEntities.stream()
								.map(postEntity -> postMapper.toDTO(postEntity))
								.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	@Transactional
	public void updateStatus(boolean status, PostDTO dto) {
		PostEntity entity = postRepository.findById(dto.getId()).orElse(null);
		if (entity != null) {
			entity.setAvailable(!status);
			postRepository.save(entity);
		}
	}
}
