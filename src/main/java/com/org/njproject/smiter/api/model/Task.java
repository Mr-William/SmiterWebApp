package com.org.njproject.smiter.api.model;

import java.util.List;

public interface Task {
	
	Long getId();
	void setId(Long id);
	String getTaskTitle();
	void setTaskTitle(String title);
	String getTaskItems();
	void setTaskItems(String taskItems);
	void addTaskItem(String task);
	String getDueDate();
	void setDueDate(String dueDate);
	List<Task> getTaskList();
	void setTaskList(List<Task> taskList);
}
