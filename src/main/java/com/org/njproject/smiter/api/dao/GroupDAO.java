package com.org.njproject.smiter.api.dao;

import java.util.List;

import com.org.njproject.smiter.api.model.Group;
import com.org.njproject.smiter.app.model.GroupImpl;

public interface GroupDAO {
	
	List<Group> findAllGroups();
	Group createGroup(Group group);
	Group findGroupById(Long id);
	boolean deleteGroup(Long id);
	Group findGroupsByName(String name);
}
