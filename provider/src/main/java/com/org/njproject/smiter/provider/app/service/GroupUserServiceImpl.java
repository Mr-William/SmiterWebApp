package com.org.njproject.smiter.provider.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.provider.api.dao.GroupUserDAO;
import com.org.njproject.smiter.provider.api.service.GroupUserService;
import com.org.njproject.smiter.provider.app.model.GroupUser;

@Service
public class GroupUserServiceImpl implements GroupUserService{

    @Autowired GroupUserDAO dao;
    
    public GroupUser findGroupUserById(Long id) {
        return dao.getGroupUser(id);
    }

    public GroupUser saveGroupUser(GroupUser user) {
        return dao.saveGroupUser(user);
    }

    public GroupUser updateGroupUser(GroupUser user) {
        return dao.updateGroupUser(user);
    }

    public void deleteGroupUser(Long id) {
        dao.deleteGroupUser(id);       
    }

    public List<GroupUser> listGroupUsers() {
        return dao.listGroupUsers();
    }

    public Boolean userExists(String username) {
        return dao.findUserByName(username);
    }
    
}
