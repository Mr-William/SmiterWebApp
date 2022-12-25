package com.org.njproject.smiter.provider.api.service;

import java.util.List;

import com.org.njproject.smiter.provider.app.model.Group;

public interface GroupService {
    
    List<Group> getAllGroups();
	
    Group createGroup(Group group);
	
    Group findGroupByName(String name);
	
    void deleteGroup(Group group);

    Group findGroupById(Long id);

    Group updateGroup(Group group);
}
