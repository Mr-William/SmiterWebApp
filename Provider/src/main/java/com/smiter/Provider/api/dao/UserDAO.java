package com.smiter.Provider.api.dao;

import java.util.List;

import com.smiter.Provider.app.model.Login;
import com.smiter.Provider.app.model.User;

public interface UserDAO {
    
    List<User> findAllUsers();
	
    User createUser(User user);
	
    User findUserByName(String name);
	
    User findUserById(Long userId);
	
    void removeUser(Long userId);
	
    String validLogin(Login login);
	
    User findUserByUserName(String userName);

    User updateUser(User user);
	
    void populateUsers();

    void deleteUserById(Long id);
}
