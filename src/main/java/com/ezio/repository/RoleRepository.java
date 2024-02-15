package com.ezio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findFirstByRole(String role);

	List<Role> findAllByRole(String role);

}
