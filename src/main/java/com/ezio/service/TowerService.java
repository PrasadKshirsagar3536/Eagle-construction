package com.ezio.service;

import java.util.List;

import com.ezio.entity.Project;
import com.ezio.entity.Tower;

public interface TowerService {

	Tower addTower(Tower tower);
    List<Tower> getAllTower();
    Tower getTowerById(Long id);
	void deleteTowerById(Long id);
	List<Project> getAllProjects();
    List<Tower> getTowersByProjectId(Long projectId);
}
