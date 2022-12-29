package com.smiter.Provider.app.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.smiter.Provider.app.daoimpl.UserDAOImpl;

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
		userName = user.getUsername();
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
