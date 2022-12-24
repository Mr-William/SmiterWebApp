package com.org.njproject.smiter.provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.njproject.smiter.provider.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

    User findByUserName(String name);
    
}
