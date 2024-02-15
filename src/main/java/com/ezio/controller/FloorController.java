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

import com.ezio.entity.Floor;
import com.ezio.service.FloorService;

@Controller
public class FloorController {

	@Autowired
	private FloorService floorService;


	@PostMapping("/addFloor")
	@ResponseBody
	public Floor addFloor(@RequestBody Floor floor) {
		return floorService.addFloor(floor);
	}
	
	@GetMapping("/getAllFloor")
	@ResponseBody
	public List<Floor> getFloors(){
		return floorService.getAllFloor();
	}
	
	@GetMapping("/showOneFloor/{id}")
	@ResponseBody
	public Floor showOne(@PathVariable Long id) {
		return floorService.getFloorById(id);
	}
	
	@GetMapping("/getFloorsByTower/{towerId}")
	@ResponseBody
	public List<Floor> getAllFloors(@PathVariable Long towerId) {
		return floorService.getFloorsByTowerId(towerId);
	}
	

	@DeleteMapping("/removeFloor/{id}")
	@ResponseBody
	public void delete(@PathVariable Long id) {
		floorService.deleteFloorById(id);
	}
	
	@GetMapping("/admin-floor")
	public String showFloorPage() {
		return "admin/admin-add-floor";
	}

}
