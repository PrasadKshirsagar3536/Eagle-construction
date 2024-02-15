package com.ezio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.entity.Flat;

public interface FlatRepository extends JpaRepository<Flat, Long>{

	List<Flat> findByFloorId(Long floorId);

}
