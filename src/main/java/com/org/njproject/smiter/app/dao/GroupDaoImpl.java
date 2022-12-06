package com.org.njproject.smiter.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.njproject.smiter.api.dao.GroupDAO;
import com.org.njproject.smiter.api.model.Group;
import com.org.njproject.smiter.api.service.LoginService;
import com.org.njproject.smiter.app.model.GroupImpl;


@Repository
public class GroupDaoImpl implements GroupDAO{
	
	@Autowired
	private LoginService loggedIn;
	
	private static Long groupId = (long) 0;
	private static List<GroupImpl> groups = new ArrayList<>();
	
	static {
		groups = populateGroups();
	}
	
	private static List<GroupImpl> populateGroups(){
		GroupImpl group = new GroupImpl();
		groups.add(group);
		
		return groups;
	}

	@Override
	public List<Group> findAllGroups() {
		List<Group> ret = new ArrayList<>();
		ret.addAll(groups);
		return ret;
	}

	@Override
	public Group createGroup(Group group) {
		if(group.getName() != null) {
			Group foundGroup = findGroupByName(group.getName());
			if(foundGroup != null) {
				return null;
			}
		}
		group.setId(++groupId);
		group.setOwner(loggedIn.getLoggedIn());
		group.addUser(loggedIn.getLoggedIn());
		groups.add((GroupImpl)group);
		
		return group;
}
	
	@Override
	public Group findGroupById(Long id) {
		return groups.stream()
				  .filter(group -> id.equals(group.getId()))
				  .findAny()
				  .orElse(null);
	}

	@Override
	public boolean deleteGroup(Long id) {
		return groups.removeIf(group -> id.equals(group.getId()));
	}
	
	@Override
	public Group findGroupsByName(String name) {
		return groups.stream()
				.filter(group -> name.equals(group.getName()))
				.findAny()
				.orElse(null);
	}
	
	public Group findGroupByName(String name) {
		return groups.stream()
				  .filter(group -> name.equals(group.getName()))
				  .findAny()
				  .orElse(null);
	}
	
}
