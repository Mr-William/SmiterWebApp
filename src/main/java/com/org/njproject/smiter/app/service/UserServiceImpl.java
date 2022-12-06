package com.org.njproject.smiter.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.api.dao.UserDAO;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO users;

	@Override
	public User createUser(User user) {
		return users.createUser(user);
	}

	@Override
	public User findUserByName(String name) {
		return users.findUserByName(name);
	}

	@Override
	public boolean deleteUser(User user) {
		return users.removeUser(user.getId());
	}

}
