package com.smiter.Provider.app.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smiter.Provider.api.dao.GroupDAO;
import com.smiter.Provider.app.model.Group;
import com.smiter.Provider.app.repo.GroupRepo;

import jakarta.transaction.Transactional;

@Repository
public class GroupDAOImpl implements GroupDAO {

    @Autowired
    private GroupRepo groups;

    @Transactional
    public List<Group> findAllGroups() {
        return groups.findAll();
    }

    @Transactional
    public Group createGroup(Group group) {
        groups.save(group);

        return group;
    }

    @Transactional
    public Group findGroupById(Long id) {
        Optional<Group> group = groups.findById(id);
        return group.get();
    }

    @Transactional
    public void deleteGroup(Long id) {
        groups.deleteById(id);
    }

    @Transactional
    public Group findGroupsByName(String name) {
        return groups.findByName(name);
    }

    @Transactional
    public Group updateGroup(Group group){
        Group current = findGroupById(group.getId());
        current.setId(group.getId());
        current.setName(group.getName());
        current.setGroupEmail(group.getGroupEmail());
        current.setOwnerName(group.getOwnerName());
        current.setTaskListCount(group.getTaskListCount());
        current.setMemberCount(group.getMemberCount());

        return group;        
    }
   
}
