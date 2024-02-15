package com.ezio.service;

import java.util.List;

import com.ezio.entity.Role;

public interface RoleService  {

	Role addRole(Role role);//add method
    List<Role> getAllRole();//getall method
	Role getRoleById(Long id);//get by id
	void deleteRoleById(Long id);//delete me
	
	List<Role> findAllByRole(String role);
}
