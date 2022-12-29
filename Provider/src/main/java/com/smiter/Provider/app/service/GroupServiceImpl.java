package com.smiter.Provider.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.api.dao.GroupDAO;
import com.smiter.Provider.api.service.GroupService;
import com.smiter.Provider.app.model.Group;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupDAO dao;
    
    public List<Group> getAllGroups() {
        return dao.findAllGroups();
    }

    public Group createGroup(Group group) {
        return dao.createGroup(group);
    }

    public Group findGroupByName(String name) {
        return dao.findGroupsByName(name);
    }

    public void deleteGroup(Group group) {
        dao.deleteGroup(group.getId());
    }

    public Group findGroupById(Long id){
        return dao.findGroupById(id);
    }

    @Override
    public Group updateGroup(Group group) {
        return dao.updateGroup(group);
    }
    
}
