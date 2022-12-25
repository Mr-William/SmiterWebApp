package com.org.njproject.smiter.provider.api.service;

import java.util.List;

import com.org.njproject.smiter.provider.app.model.GroupUser;

public interface GroupUserService {
    
    GroupUser findGroupUserById(Long id);

	GroupUser saveGroupUser(GroupUser user);

	GroupUser updateGroupUser(GroupUser user);

	void deleteGroupUser(Long id);

	List<GroupUser> listGroupUsers();

	Boolean userExists(String username);
}
