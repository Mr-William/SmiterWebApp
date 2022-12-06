package com.org.njproject.smiter.api.model;

import java.util.List;

public interface Group {
	
	Long getId();
	void setId(Long id);
	String getName();
	void setName(String name);
	List<Task> getTaskList();
	void setTaskList(List<Task> taskList);
	void addTask(Task task);
	boolean removeTask(Long id);
	void deleteTaskList(Long id);
	List<User> getUserList();
	void addUser(User user);
	User getOwner();
	void setOwner(User owner);
	String getEmail();
	void setEmail(String email);
	String getOwnerName();
	void setOwnerName(User user);
	Integer getMemberCount();
	Integer getTaskListCount();
	
}
