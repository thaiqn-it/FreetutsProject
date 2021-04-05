package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.AdminDTO;
import com.mockproject.freetutsproject.entity.AdminEntity;
import com.mockproject.freetutsproject.entity.CategoryEntity;
import com.mockproject.freetutsproject.mapper.AdminMapper;
import com.mockproject.freetutsproject.repository.AdminRepository;
import com.mockproject.freetutsproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    @Transactional (readOnly = true)
    public List<AdminDTO> findAll() {
        List<AdminEntity> entities = adminRepository.findAll();
        if (!entities.isEmpty()){
            return entities.stream()
                    .map(entity -> adminMapper.toDTO(entity))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public AdminDTO findById(Long id) {
        AdminEntity entities = adminRepository.findById(id).orElse(null);
        if (entities != null){
            return adminMapper.toDTO(entities);
        }
        return null;
    }

    @Override
    @Transactional
    public AdminDTO save(AdminDTO adminDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        adminDTO.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        AdminEntity entity = adminRepository.save(adminMapper.toEntity(adminDTO));
        return adminMapper.toDTO(entity);
    }

    @Override
    @Transactional (readOnly = true)
    public AdminDTO findByUsername(String username) {
        return adminMapper.toDTO(adminRepository.findByUsernameAndAvailableTrue(username));
    }

    @Override
    @Transactional (readOnly = true)
    public boolean checkUsernameExist(String username) {
        return adminRepository.existsByUsername(username);
    }

    @Override
    @Transactional (readOnly = true)
    public boolean checkPasswordValid(AdminDTO adminDTO) {
        AdminEntity entity = adminRepository.findById(adminDTO.getId()).orElse(null);
        if (BCrypt.checkpw(adminDTO.getOldPassword(),entity.getPassword())){
            return true;
        }
        return false;
    }
}
