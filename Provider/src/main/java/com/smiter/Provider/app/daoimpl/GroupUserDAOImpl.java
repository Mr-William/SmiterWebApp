package com.smiter.Provider.app.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smiter.Provider.api.dao.GroupUserDAO;
import com.smiter.Provider.app.model.GroupUser;
import com.smiter.Provider.app.repo.GroupUserRepo;

import jakarta.transaction.Transactional;

@Repository
public class GroupUserDAOImpl implements GroupUserDAO {
    
    @Autowired
    private GroupUserRepo repo;

    @Transactional
    public List<GroupUser> findAllGroupUsers(){
        return repo.findAll();
    }

    @Transactional
    public GroupUser saveGroupUser(GroupUser user) {
        return repo.save(user);
    }

    @Transactional
    public GroupUser getGroupUser(Long id) {
        return repo.getById(id);
    }

    @Transactional
    public void deleteGroupUser(Long id) {
        repo.deleteById(id);        
    }

    @Transactional
    public GroupUser findGroupUserById(Long id) {
        Optional<GroupUser> user = repo.findById(id);
        return user.get();
    }

    @Transactional
    public GroupUser updateGroupUser(GroupUser user) {
        GroupUser current = findGroupUserById(user.getId());
		current.setId(user.getId());
		current.setName(user.getName());
		current.setDob(user.getDob());
		current.setEmail(user.getEmail());
		
		return user;
    }

    @Transactional
    public List<GroupUser> listGroupUsers() {
        return repo.findAll();
    }

    @Transactional
    public Boolean findUserByName(String username) {
        return repo.findAll().contains(username);
    }
}
