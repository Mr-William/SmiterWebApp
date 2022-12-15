package com.org.njproject.smiter.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.njproject.smiter.api.dao.GroupUserDAO;
import com.org.njproject.smiter.api.model.GroupUser;
import com.org.njproject.smiter.api.service.GroupUserService;

@Service
public class GroupUserServiceImpl implements GroupUserService{
	
	@Autowired
	private GroupUserDAO users;

	@Override
	@Transactional
	public GroupUser findGroupUserById(Long id) {
		return users.findGroupUserById(id);
	}

	@Override
	@Transactional
	public void saveGroupUser(GroupUser user) {
		System.out.println("=====Groupuser: " + user.getUsername() + "============");
		System.out.println("=====Groupuser: " + user.getEmail() + "============");
		System.out.println("=====Groupuser: " + user.getId() + "============");
		users.saveGroupUser(user);		
	}

	@Override
	@Transactional
	public void updateGroupUser(GroupUser user) {
		users.updateGroupUser(user);
		
	}

	@Override
	@Transactional
	public void deleteGroupUser(Long id) {
		users.deleteGroupUser(id);
		
	}

	@Override
	@Transactional
	public List<GroupUser> listGroupUsers() {
		return users.listGroupUsers();
	}

	@Override
	@Transactional
	public Boolean userExists(String username) {
		return users.findUserByName(username);
	}

}
