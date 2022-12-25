package com.org.njproject.smiter.provider.api.dao;

import java.util.List;

import com.org.njproject.smiter.provider.app.model.Task;

public interface TaskDAO {
    
    List<Task> findAllTasks();

	Task findTaskById(Long id);

	Task saveTask(Task task);

	void deleteTaskById(Long id);

	Task updateTask(Task task);
}
