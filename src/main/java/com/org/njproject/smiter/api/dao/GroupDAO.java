package com.org.njproject.smiter.api.dao;

import java.util.List;

import com.org.njproject.smiter.api.model.Group;

public interface GroupDAO {
	
	List<Group> findAllGroups();
	Group createGroup(Group group);
	Group findGroupById(Long id);
	boolean deleteGroup(Long id);
	Group findGroupsByName(String name);
}
 