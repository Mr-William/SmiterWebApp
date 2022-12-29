package com.smiter.Provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smiter.Provider.app.model.Group;

public interface GroupRepo extends JpaRepository<Group, Long>{

    Group findByName(String name);
        
}
