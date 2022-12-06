package com.org.njproject.smiter.api.service;

import java.util.List;

import com.org.njproject.smiter.api.model.Task;

public interface TaskService {
	
	List<Task> getTaskList();
	boolean deleteTask(Task task);
	void addTask(Task task);
	
}
