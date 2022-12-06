package com.org.njproject.smiter.api.service;

import java.util.List;

import com.org.njproject.smiter.app.model.GroupUser;



public interface GroupUserService {
	
	GroupUser findById(long id);
	
	GroupUser findByName(String name);
	
	void saveUser(GroupUser user);
	
	void updateUser(GroupUser user);
	
	void deleteUserById(long id);

	List<GroupUser> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(GroupUser user);
	
}
