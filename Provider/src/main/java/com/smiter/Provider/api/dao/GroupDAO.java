package com.smiter.Provider.api.dao;

import java.util.List;

import com.smiter.Provider.app.model.Group;

public interface GroupDAO {
    
    List<Group> findAllGroups();
	
    Group createGroup(Group group);
	
    Group findGroupById(Long id);
	
    void deleteGroup(Long id);
	
    Group findGroupsByName(String name);

    Group updateGroup(Group group);
}
