package com.smiter.Provider.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.api.dao.UserDAO;
import com.smiter.Provider.api.service.UserService;
import com.smiter.Provider.app.model.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO dao;
    
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public User findUserById(Long id) {
        return dao.findUserById(id);
    }

    public User saveUser(User user) {
        return dao.createUser(user);
    }

    public User updateUser(User user) {
        return dao.updateUser(user);
    }

    public void deleteUserById(Long id) {
        dao.deleteUserById(id);
    }
    
}
