package com.ezio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.entity.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long>{

	List<Floor> findByTowerId(Long towerId);// userdefine queary


}
