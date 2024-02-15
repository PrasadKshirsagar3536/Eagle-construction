package com.ezio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.entity.Task;
import com.ezio.repository.TaskRepository;

@Service
public class TaskServiceIMPL implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task addTask(Task task) {
		return taskRepository.save(task) ;
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public void deleteTaskById(Long id) {
		taskRepository.deleteById(id);
	}	

}
