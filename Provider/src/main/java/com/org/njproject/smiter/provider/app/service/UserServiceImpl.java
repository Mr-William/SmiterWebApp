package com.org.njproject.smiter.provider.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.provider.api.dao.UserDAO;
import com.org.njproject.smiter.provider.api.service.UserService;
import com.org.njproject.smiter.provider.app.model.User;

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
