package com.org.njproject.smiter.api.model;

public interface Login {
	
	String getUserName();
	void setUserName(String userName);
	String getPassword();
	void setPassword(String password);
	String getName();
	void setName(String name);
	void setLoggedIn(User user);
}
