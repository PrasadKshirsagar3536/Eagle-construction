package com.ezio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezio.entity.Role;
import com.ezio.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	// Backend API's

	@PostMapping("/addRole")
	@ResponseBody
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

	@GetMapping("/showOneRole/{id}")
	@ResponseBody
	public Role showOne(@PathVariable Long id) {
		return roleService.getRoleById(id);
	}

	@DeleteMapping("/removeRole/{id}")
	@ResponseBody
	public void delete(@PathVariable Long id) {
		roleService.deleteRoleById(id);
	}

	@GetMapping("/findAllByRoles/{role}")
	@ResponseBody
	public List<Role> findAllByRoles(@PathVariable String role) {
		return roleService.findAllByRole(role);
	}

	// Frontend API's

	@GetMapping("/department")
	public String departmentPage() {
		return "admin/setting/department";
	}

	@GetMapping("/position")
	public String positionPage() {
		return "admin/setting/position";
	}

}
