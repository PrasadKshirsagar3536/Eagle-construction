package com.ezio.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.entity.Project;
import com.ezio.repository.ProjectRepository;

@Service
public class ProjectServiceIMPL implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project addProject(Project project) {
		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		project.setDate(date);
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public void deleteProjectById(Long id) {
		projectRepository.deleteById(id);
	}
	


}
