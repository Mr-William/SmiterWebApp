package com.org.njproject.smiter.api.dao;

import java.util.List;

import com.org.njproject.smiter.api.model.Login;
import com.org.njproject.smiter.api.model.User;

public interface UserDAO {
	
	List<User> findAllUsers();
	User createUser(User user);
	User findUserByName(String name);
	User findUserById(Long userId);
	boolean removeUser(Long userId);
	String validLogin(Login login);
	User findUserByUserName(String userName);
}
