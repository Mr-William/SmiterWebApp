package com.org.njproject.smiter.provider.api.service;

import java.util.List;

import com.org.njproject.smiter.provider.app.model.Task;

public interface TaskService {
    
    List<Task> getTaskList();
	
    void deleteTask(Task task);
	
    Task addTask(Task task);
}
