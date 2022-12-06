package com.org.njproject.smiter.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.api.model.Group;
import com.org.njproject.smiter.api.model.Task;
import com.org.njproject.smiter.api.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	Group group;

	@Override
	public List<Task> getTaskList() {
		return group.getTaskList();
	}

	@Override
	public boolean deleteTask(Task task) {
		return group.removeTask(task.getId());
	}

	@Override
	public void addTask(Task task) {
		group.addTask(task);
	}

}
