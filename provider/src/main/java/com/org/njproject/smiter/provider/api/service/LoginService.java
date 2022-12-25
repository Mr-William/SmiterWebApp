package com.org.njproject.smiter.provider.api.service;

import com.org.njproject.smiter.provider.app.model.Login;
import com.org.njproject.smiter.provider.app.model.User;

public interface LoginService {
    
    boolean isValid(Login login);
	
    void setLoggedIn(User user);
	
    User getLoggedIn();
	
    String validateUser(Login login);
	
    boolean isLoggedIn();
}
