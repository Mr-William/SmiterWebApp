package com.org.njproject.smiter.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.api.dao.UserDAO;
import com.org.njproject.smiter.api.model.Login;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.api.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	private User loggedIn;
	
	@Autowired
	private UserDAO users;

	@Override
	public boolean isValid(Login login) {
		if(validateUser(login).equals("valid")) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void setLoggedIn(User user) {
		this.loggedIn = user;
	}

	@Override
	public User getLoggedIn() {
		return loggedIn;
	}
	
	@Override
	public String validateUser(Login login) {
		return users.validLogin(login);
	}

	@Override
	public boolean isLoggedIn() {
		return loggedIn != null;
	}

}
