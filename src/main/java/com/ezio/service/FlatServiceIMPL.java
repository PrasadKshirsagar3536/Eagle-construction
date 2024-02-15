package com.ezio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.entity.Flat;
import com.ezio.repository.FlatRepository;

@Service
public class FlatServiceIMPL implements FlatService {
	
	@Autowired
	private FlatRepository flatRepository;

	@Override
	public Flat addFlat(Flat flat) {
		return flatRepository.save(flat);
	}

	@Override
	public List<Flat> getAllFlat() {
		return flatRepository.findAll();
	}

	@Override
	public Flat getFlatById(Long id) {
		return flatRepository.findById(id).get();
	}

	@Override
	public void deleteFlatById(Long id) {
		flatRepository.deleteById(id);
	}

	@Override
	public List<Flat> getFlatsByFloor(Long floorId) {
		return flatRepository.findByFloorId(floorId);
	}
	
	

}
