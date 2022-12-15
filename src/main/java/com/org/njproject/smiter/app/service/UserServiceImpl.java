package com.org.njproject.smiter.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.njproject.smiter.api.dao.UserDAO;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO users; 

	@Override
	@Transactional
	public User createUser(User user) {
		return users.createUser(user);
	}

	@Override
	@Transactional
	public User findUserByName(String name) {
		return users.findUserByName(name);
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		return users.removeUser(user.getId());
	}

}
