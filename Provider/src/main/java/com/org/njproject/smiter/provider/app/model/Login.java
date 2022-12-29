package com.org.njproject.smiter.provider.app.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.njproject.smiter.provider.app.daoimpl.UserDAOImpl;

public class Login {

    String userName;
	String password;
	String name;
	
	public Login() {
		userName = "";
		password = "";
		name = "";
	}
	public Login(User user) {
		userName = user.getUserName();
		name = user.getName();
		password = user.getPassword();
	}
	
	@Autowired
	UserDAOImpl userList;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLoggedIn(User user) {
	}
	
	public String isValid(Login login) {
		return userList.validLogin(login);
	}

}
