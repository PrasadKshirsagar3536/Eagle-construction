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

import com.ezio.entity.Flat;
import com.ezio.service.FlatService;

@Controller
public class FlatContoller {

	@Autowired
	private FlatService flatService;

	@PostMapping("/addFlat")
	@ResponseBody
	public Flat addFlat(@RequestBody Flat flat) {
		return flatService.addFlat(flat);
	}

	@GetMapping("/getAllFlat")
	@ResponseBody
	public List<Flat> getFlat() {
		return flatService.getAllFlat();
	}

	@GetMapping("/showOneFlat/{id}")
	@ResponseBody
	public Flat showOne(@PathVariable Long id) {
		Flat flatById = flatService.getFlatById(id);
		return flatById;
	}

	@DeleteMapping("/removeFlat/{id}")
	@ResponseBody
	public void delete(@PathVariable Long id) {
		flatService.deleteFlatById(id);
	}
	
	@GetMapping("/getFlatsByFloor/{floorId}")
	@ResponseBody
	public List<Flat> getFlatsByFloorId(@PathVariable Long floorId){
		return flatService.getFlatsByFloor(floorId);
	}

	@GetMapping("/admin-flat")
	public String showFlatPage() {
		return "admin/admin-add-flat";
	}
}
