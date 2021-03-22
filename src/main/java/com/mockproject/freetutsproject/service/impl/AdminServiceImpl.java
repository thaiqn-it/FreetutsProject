package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.dto.AdminDTO;
import com.mockproject.freetutsproject.mapper.AdminMapper;
import com.mockproject.freetutsproject.repository.AdminRepository;
import com.mockproject.freetutsproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<AdminDTO> findAll() {
        return null;
    }

    @Override
    public AdminDTO findById(Long id) {
        return null;
    }

    @Override
    public AdminDTO save(AdminDTO adminDTO) {
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public AdminDTO findByUsername(String username) {
        return adminMapper.toDTO(adminRepository.findByUsername(username));
    }
}
