package com.ezio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezio.entity.Project;
import com.ezio.entity.Tower;
import com.ezio.service.TowerService;

import jakarta.transaction.Transactional;

@Controller
public class TowerController {

	@Autowired
	private TowerService towerService;

	@PostMapping("/addTower")
	@ResponseBody
	public Tower addTower(@RequestBody Tower tower) {
		return towerService.addTower(tower);
	}

	@GetMapping("/getAllTower")
	@ResponseBody
	public List<Tower> getTowers() {
		return towerService.getAllTower();
	}

	@GetMapping("/showOneTower/{id}")
	@ResponseBody
	public Tower showOne(@PathVariable Long id) {
		return towerService.getTowerById(id);
	}

	@GetMapping("/getTowersByProject/{projectId}")
	@ResponseBody
	public List<Tower> getAllTowers(@PathVariable Long projectId) {
		return towerService.getTowersByProjectId(projectId);
	}

	@Transactional
	@DeleteMapping("/removeTower/{id}")
	@ResponseBody
	public void delete(@PathVariable Long id) {
		towerService.deleteTowerById(id);
	}

	@GetMapping("/admin-tower")
	public String adminTowerPage(Model model) {
		List<Project> projects = towerService.getAllProjects();
		model.addAttribute("projects", projects);
		return "admin/admin-add-tower";
	}

}
