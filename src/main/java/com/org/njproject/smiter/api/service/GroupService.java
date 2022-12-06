package com.org.njproject.smiter.api.service;

import java.util.List;

import com.org.njproject.smiter.api.model.Group;

public interface GroupService {
	
	List<Group> getAllGroups();
	Group createGroup(Group group);
	Group findGroupByName(String name);
	boolean deleteGroup(Group group);
	boolean findGroup(String groupName);
}
