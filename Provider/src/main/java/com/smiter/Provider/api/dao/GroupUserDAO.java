package com.smiter.Provider.api.dao;

import java.util.List;

import com.smiter.Provider.app.model.GroupUser;

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
