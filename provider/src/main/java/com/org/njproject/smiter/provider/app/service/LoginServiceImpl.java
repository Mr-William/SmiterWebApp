package com.org.njproject.smiter.provider.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.provider.api.dao.UserDAO;
import com.org.njproject.smiter.provider.api.service.LoginService;
import com.org.njproject.smiter.provider.app.model.Login;
import com.org.njproject.smiter.provider.app.model.User;

@Service
public class LoginServiceImpl implements LoginService{

    private User loggedIn;

    @Autowired
    private UserDAO users;
    
    public boolean isValid(Login login) {
        if(validateUser(login).equals("valid")) {
			return true;
		}
		else {
			return false;
		}
    }

    public void setLoggedIn(User user) {
        this.loggedIn = user; 
    }

    public User getLoggedIn() {
        return loggedIn;
    }

    public String validateUser(Login login) {
        return users.validLogin(login);
    }

    public boolean isLoggedIn() {
        return loggedIn != null;
    }
    
}
