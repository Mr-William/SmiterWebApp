package com.org.njproject.smiter.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.api.dao.GroupDAO;
import com.org.njproject.smiter.api.model.Group;
import com.org.njproject.smiter.api.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupDAO groups = null;

	@Override
	public List<Group> getAllGroups() {
		return groups.findAllGroups();
	}

	@Override
	public Group createGroup(Group group) {
		return groups.createGroup(group);
	}

	@Override
	public Group findGroupByName(String name) {
		return groups.findGroupsByName(name);
	}

	@Override
	public boolean deleteGroup(Group group) {
		return groups.deleteGroup(group.getId());
	}

	@Override
	public boolean findGroup(String groupName) {
		return groups.findGroupsByName(groupName) == null;
	}

}
