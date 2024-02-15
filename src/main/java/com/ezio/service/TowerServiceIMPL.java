package com.ezio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.entity.Project;
import com.ezio.entity.Tower;
import com.ezio.repository.ProjectRepository;
import com.ezio.repository.TowerRepository;

@Service
public class TowerServiceIMPL implements TowerService {

	@Autowired
	private TowerRepository towerRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Tower addTower(Tower tower) {
		return towerRepository.save(tower);
	}

	/*
	 * @Override public List<Tower> getAllTower() { return
	 * towerRepository.findAll(); }
	 */

	@Override
	public List<Tower> getAllTower() { // Change method name to getAllTower
		List<Tower> towers = towerRepository.findAll();

		// Ensure project names are populated
		for (Tower tower : towers) {
			if (tower.getProject() != null) {
				Project project = tower.getProject();
				// Check if projectName is null and set a default if needed
				if (project.getProjectName() == null) {
					project.setProjectName("Default Project Name");
				}
			}
		}

		return towers;
	}

	@Override
	public Tower getTowerById(Long id) {
		return towerRepository.findById(id).get();
	}

	@Override
	public void deleteTowerById(Long id) {
		towerRepository.deleteById(id);
	}

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public List<Tower> getTowersByProjectId(Long projectId) {

		return towerRepository.findByProjectId(projectId);
	}

}
