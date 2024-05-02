package com.davv.scholarship.davv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davv.scholarship.davv.entity.Role;
import com.davv.scholarship.davv.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	public RoleRepository roleRepository;

	public Role findRoleByName(String role) {
		// TODO Auto-generated method stub
		return roleRepository.findRoleByName(role);
	}

	public void save(Role role) {
		roleRepository.save(role);
	}

}
