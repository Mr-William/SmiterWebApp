package com.org.njproject.smiter.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.njproject.smiter.api.model.Login;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.app.dao.UserDaoImpl;

@Component
public class LoginImpl implements Login {
	
	String userName;
	String password;
	String name;
	
	private boolean isValid;
	private User user;
	
	public LoginImpl() {
		userName = "";
		password = "";
		name = "";
	}
	public LoginImpl(User user) {
		userName = user.getUserName();
		name = user.getName();
		password = user.getPassword();
	}
	
	@Autowired
	UserDaoImpl userList;

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setLoggedIn(User user) {
		this.user = user;
	}
	
	public String isValid(Login login) {
		return userList.validLogin(login);
	}

}
