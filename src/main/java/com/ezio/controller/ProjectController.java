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

import com.ezio.entity.Project;
import com.ezio.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("/addProject")
	@ResponseBody
	public Project AddProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}

	@GetMapping("/getAllProjects")
	@ResponseBody
	public List<Project> GetAllProjects() {
		return projectService.getAllProjects();
	}

	@GetMapping("/getProjectById/{id}")
	@ResponseBody
	public Project GetProjectById(@PathVariable Long id) {
		return projectService.getProjectById(id);
	}

	@DeleteMapping("/deleteProjectById/{id}")
	@ResponseBody
	public void DeleteProjectById(@PathVariable Long id) {
		projectService.deleteProjectById(id);
	}

	@GetMapping("/admin-project")
	public String adminEmployeePage() {

		return "admin/admin-add-project";
	}

}
