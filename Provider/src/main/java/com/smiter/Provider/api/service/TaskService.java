package com.smiter.Provider.api.service;

import java.util.List;

import com.smiter.Provider.app.model.Task;

public interface TaskService {
    
    List<Task> getTaskList();
	
    void deleteTask(Task task);
	
    Task addTask(Task task);
}
