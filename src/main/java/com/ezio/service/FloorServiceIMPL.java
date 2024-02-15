package com.ezio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.entity.Floor;
import com.ezio.repository.FloorRepository;

@Service
public class FloorServiceIMPL implements FloorService {
	
	@Autowired
	private FloorRepository floorRepository;
	
	
	public Floor addFloor(Floor floor) {
		return floorRepository.save(floor);
	}

	@Override
	public List<Floor> getAllFloor() {
		return floorRepository.findAll();
	}

	@Override
	public Floor getFloorById(Long id) {
		return floorRepository.findById(id).get();
	}

	@Override
	public void deleteFloorById(Long id) {	
		floorRepository.deleteById(id);
	}

	@Override
    public List<Floor> getFloorsByTowerId(Long towerId) {
        return floorRepository.findByTowerId(towerId);
 }

	

}
