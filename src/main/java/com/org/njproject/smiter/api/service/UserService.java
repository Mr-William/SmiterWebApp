package com.org.njproject.smiter.api.service;

import com.org.njproject.smiter.api.model.User;

public interface UserService {
	
	User createUser(User user);
	User findUserByName(String name);
	boolean deleteUser(User user);
}
