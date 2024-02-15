package com.ezio.service;

import java.util.List;

import com.ezio.entity.Floor;

public interface FloorService {

	Floor addFloor(Floor floor);
    List<Floor> getAllFloor();
    Floor getFloorById(Long id);
	void deleteFloorById(Long id);
    List<Floor> getFloorsByTowerId(Long towerId);
}
