package com.ezio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.entity.Role;
import com.ezio.repository.RoleRepository;

@Service
public class RoleServiceIMPL implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public void deleteRoleById(Long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public List<Role> findAllByRole(String role) {
		return roleRepository.findAllByRole(role);
	}

}
