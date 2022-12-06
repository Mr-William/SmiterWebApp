package com.org.njproject.smiter.app.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.org.njproject.smiter.api.model.Task;

@Component
public class TaskImpl implements Task {
	
	Long id = (long) 0;
	String taskTitle;
	String taskItems;
	List<Task> taskList;
	String dueDate;
	
	public TaskImpl() {
		++id;
	}	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getTaskTitle() {
		return taskTitle;
	}

	@Override
	public void setTaskTitle(String title) {
		this.taskTitle = title;
	}

	@Override
	public String getTaskItems() {
		return taskItems;
	}

	@Override
	public void setTaskItems(String taskItems) {
		this.taskItems = taskItems;
	}

	@Override
	public void addTaskItem(String task) {
		this.taskItems = task;
	}

	@Override
	public String getDueDate() {
		return dueDate;
	}

	@Override
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public List<Task> getTaskList() {
		return taskList;
	}

	@Override
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

}
