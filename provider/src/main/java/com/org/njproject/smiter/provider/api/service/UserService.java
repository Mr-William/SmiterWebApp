package com.org.njproject.smiter.provider.api.service;

import java.util.List;

import com.org.njproject.smiter.provider.app.model.User;

public interface UserService {
    
    List<User> findAllUsers();
    
    User findUserById(Long id);
    
    User saveUser(User user);
    
    User updateUser(User user);
    
    void deleteUserById(Long id);
}
