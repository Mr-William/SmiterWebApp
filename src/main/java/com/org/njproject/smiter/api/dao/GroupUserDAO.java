package com.org.njproject.smiter.api.dao;

import java.util.List;

import com.org.njproject.smiter.api.model.GroupUser;

public interface GroupUserDAO {
	public void saveGroupUser(GroupUser user);
	public GroupUser getGroupUser(Long id);
	public void deleteGroupUser(Long id);
	public GroupUser findGroupUserById(Long id);
	public void updateGroupUser(GroupUser user);
	public List<GroupUser> listGroupUsers();
	public Boolean findUserByName(String username);
}
