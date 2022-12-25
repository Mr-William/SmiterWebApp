package com.org.njproject.smiter.provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.njproject.smiter.provider.app.model.Group;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long>{

    Group findByName(String name);
        
}
