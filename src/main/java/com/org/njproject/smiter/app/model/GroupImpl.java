package com.org.njproject.smiter.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.org.njproject.smiter.api.model.Group;
import com.org.njproject.smiter.api.model.Task;
import com.org.njproject.smiter.api.model.User;

@Component
public class GroupImpl implements Group {
	
	Long id = (long) 0;
	String name;
	String email;
	String ownerName;
	List<Task> taskList = new ArrayList<>();
	List<User> userList = new ArrayList<>();
	private User owner;
	Integer taskListCount;
	Integer memberCount;
	
	public GroupImpl() {
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Task> getTaskList() {
		return taskList;
	}

	@Override
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	@Override
	public void addTask(Task task) {
		this.taskList.add(task);
	}

	@Override
	public boolean removeTask(Long id) {
		return this.taskList.removeIf(task -> id.equals(task.getId()));
	}

	@Override
	public void deleteTaskList(Long id) {
		this.taskList.removeAll(taskList);
	}

	@Override
	public List<User> getUserList() {
		return userList;
	}

	@Override
	public void addUser(User user) {
		this.userList.add(user);
	}
	
	@Override
	public void setOwner(User o) {
		this.owner = o;
		this.ownerName = o.getName();
	}
	
	@Override
	public User getOwner() {
		return owner;
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
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getOwnerName() {
		return ownerName;
	}
	
	@Override
	public void setOwnerName(User user) {
		this.ownerName = user.getName();
	}

	@Override
	public Integer getMemberCount() {
		return userList.size();
	}

	@Override
	public Integer getTaskListCount() {
		return taskList.size();
	}
	
}
