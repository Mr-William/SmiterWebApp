package com.smiter.Provider.api.service;

import java.util.List;

import com.smiter.Provider.app.model.User;

public interface UserService {
    
    List<User> findAllUsers();
    
    User findUserById(Long id);
    
    User saveUser(User user);
    
    User updateUser(User user);
    
    void deleteUserById(Long id);
}
