package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.AdminDTO;

public interface AdminService extends AbstractService<AdminDTO> {
    AdminDTO findByUsername(String username);
    boolean checkUsernameExist(String username);
    boolean checkPasswordValid(AdminDTO adminDTO);
}
