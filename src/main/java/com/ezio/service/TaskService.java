package com.ezio.service;

import java.util.List;

import com.ezio.entity.Task;

public interface TaskService {

	Task addTask(Task task);
	List<Task> getAllTasks();
	Task getTaskById(Long id);
	void deleteTaskById(Long id);
	
}
