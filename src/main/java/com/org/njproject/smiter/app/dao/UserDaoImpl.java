package com.org.njproject.smiter.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.org.njproject.smiter.api.dao.UserDAO;
import com.org.njproject.smiter.api.model.Login;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.app.model.UserImpl;

@Repository
public class UserDaoImpl implements UserDAO{
	
	private static Long userId = (long) 0;
	private static List<UserImpl> users = new ArrayList<>();
	
	private static List<UserImpl> populateUsers(){
		UserImpl user = new UserImpl();
		user.setCompany("");
		user.setEmail("");
		user.setId(++userId);
		user.setName("");
		user.setPassword("");
		user.setUserName("");
		user.setUserType("");
		
		users.add(user);
		return users;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> ret = new ArrayList<>();
		ret.addAll(users);
		return ret;
		
	}

	@Override
	public User createUser(User user) {
		if( user.getId() != null) {
			User foundUser = findUserById(user.getId());
		    if(foundUser != null) {
		    	users = users.stream()
		    		    .map(u -> u.getId().equals(user.getId()) ? (UserImpl) user : u)
		    		    .collect(Collectors.toList());
		    	return user; 
		    } 
		} 
		
	    user.setId(++userId);
        users.add((UserImpl) user);
        System.out.println("In userdao--user created:" + user.getName());
        return user; 
	}

	@Override
	public User findUserByName(String name) {
		return users.stream()
				  .filter(user -> name.equals(user.getName()))
				  .findAny()
				  .orElse(null);
	}

	@Override
	public boolean removeUser(Long userId) {
		return users.removeIf(user -> userId.equals(user.getId()));
	}

	@Override
	public User findUserById(Long userId) {
		return users.stream()
				  .filter(user -> userId.equals(user.getId()))
				  .findAny()
				  .orElse(null);
	}
	
	public String validLogin(Login login) {
		if(users == null) {
			populateUsers();
		}
		if(users.contains(findUserByUserName(login.getUserName()))) {
			User user = findUserByUserName(login.getUserName());
			if(login.getPassword().equals(user.getPassword())) {
				login.setName(login.getName());
				login.setLoggedIn(user);
				return "valid";
			}else {
				return "Incorrect Password";
			}
		}
		else {
			return "User Doesn't Exist";
		}
	}

	public User findUserByUserName(String userName) {
		System.out.println("In findUserByUserName, userName=" + userName);
		return users.stream()
				  .filter(user -> userName.equals(user.getUserName()))
				  .findAny()
				  .orElse(null);
	}

}

