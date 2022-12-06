package com.org.njproject.smiter.api.service;

import com.org.njproject.smiter.api.model.Login;
import com.org.njproject.smiter.api.model.User;

public interface LoginService {
	
	boolean isValid(Login login);
	void setLoggedIn(User user);
	User getLoggedIn();
	String validateUser(Login login);
	boolean isLoggedIn();
}
