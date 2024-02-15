package com.ezio.service;

import java.util.List;

import com.ezio.entity.Flat;

public interface FlatService {

	Flat addFlat(Flat flat);
    List<Flat> getAllFlat();
    Flat getFlatById(Long id);
	void deleteFlatById(Long id);
	List<Flat> getFlatsByFloor(Long floorId);
}
