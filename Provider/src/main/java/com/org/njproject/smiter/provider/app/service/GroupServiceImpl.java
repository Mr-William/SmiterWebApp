package com.org.njproject.smiter.provider.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.provider.api.dao.GroupDAO;
import com.org.njproject.smiter.provider.api.service.GroupService;
import com.org.njproject.smiter.provider.app.model.Group;

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
