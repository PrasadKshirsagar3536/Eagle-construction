package com.ezio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezio.entity.Task;
import com.ezio.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/addTask")
	@ResponseBody
	public Task addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}

	@GetMapping("/getAllTasks")
	@ResponseBody
	public List<Task> getAll() {
		return taskService.getAllTasks();
	}

	@GetMapping("/getTaskById/{id}")
	@ResponseBody
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}

	@DeleteMapping("/deleteTaskById/{id}")
	@ResponseBody
	public void deleteTaskById(@PathVariable Long id) {
		taskService.deleteTaskById(id);
	}
	
	@GetMapping("/admin-work")
	public String showWorkTable() {
		return "admin/admin-add-task-emp";
	}

}
