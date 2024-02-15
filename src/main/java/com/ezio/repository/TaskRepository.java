package com.ezio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
