package com.org.njproject.smiter.provider.api.dao;

import java.util.List;

import com.org.njproject.smiter.provider.app.model.Group;

public interface GroupDAO {
    
    List<Group> findAllGroups();
	
    Group createGroup(Group group);
	
    Group findGroupById(Long id);
	
    void deleteGroup(Long id);
	
    Group findGroupsByName(String name);

    Group updateGroup(Group group);
}
