package com.org.njproject.smiter.provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.njproject.smiter.provider.app.model.GroupUser;

@Repository
public interface GroupUserRepo extends JpaRepository<GroupUser, Long>{
    
}
