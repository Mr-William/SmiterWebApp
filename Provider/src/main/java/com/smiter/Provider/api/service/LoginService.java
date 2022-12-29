package com.smiter.Provider.api.service;

import com.smiter.Provider.app.model.Login;
import com.smiter.Provider.app.model.User;

public interface LoginService {
    
    boolean isValid(Login login);
	
    void setLoggedIn(User user);
	
    User getLoggedIn();
	
    String validateUser(Login login);
	
    boolean isLoggedIn();
}
