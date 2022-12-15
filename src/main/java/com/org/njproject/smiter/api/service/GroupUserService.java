package com.org.njproject.smiter.api.service;

import java.util.List;

import com.org.njproject.smiter.api.model.GroupUser;



public interface GroupUserService {

	GroupUser findGroupUserById(Long id);

	void saveGroupUser(GroupUser user);

	void updateGroupUser(GroupUser user);

	void deleteGroupUser(Long id);

	List<GroupUser> listGroupUsers();

	Boolean userExists(String username);
	
}
