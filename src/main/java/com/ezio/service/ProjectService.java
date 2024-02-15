package com.ezio.service;

import java.util.List;

import com.ezio.entity.Project;

public interface ProjectService {

	Project addProject(Project project);
	List<Project> getAllProjects();
	Project getProjectById(Long id);
	void deleteProjectById(Long id);
	
	
}
