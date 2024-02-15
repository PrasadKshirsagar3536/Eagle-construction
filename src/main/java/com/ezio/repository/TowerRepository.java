package com.ezio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.entity.Tower;

public interface TowerRepository extends JpaRepository<Tower, Long> {

	List<Tower> findByProjectId(Long projectId);

}
