package com.ezio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
