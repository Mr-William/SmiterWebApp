package com.org.njproject.smiter.provider.api.dao;

import java.util.List;

import com.org.njproject.smiter.provider.app.model.GroupUser;

public interface GroupUserDAO {
    
    GroupUser saveGroupUser(GroupUser user);
	
    GroupUser getGroupUser(Long id);

	void deleteGroupUser(Long id);
	
    GroupUser findGroupUserById(Long id);
	
    GroupUser updateGroupUser(GroupUser user);
	
    List<GroupUser> listGroupUsers();
	
    Boolean findUserByName(String username);

    List<GroupUser> findAllGroupUsers();
}
