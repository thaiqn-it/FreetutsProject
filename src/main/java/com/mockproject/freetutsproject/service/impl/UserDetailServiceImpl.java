package com.mockproject.freetutsproject.service.impl;

import com.mockproject.freetutsproject.entity.AdminEntity;
import com.mockproject.freetutsproject.security.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mockproject.freetutsproject.repository.AdminRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminEntity adminEntity = adminRepository.findByUsernameAndAvailableTrue(username);
		if (adminEntity == null) {
			throw new UsernameNotFoundException(username);
		}

		Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		grantedAuthoritySet.add(new SimpleGrantedAuthority("ADMIN"));
		return new CustomUser(adminEntity.getId(), adminEntity.getFullname(),
								adminEntity.getUsername(), adminEntity.getPassword(),
								grantedAuthoritySet);
	}
}
