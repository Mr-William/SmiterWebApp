package com.smiter.Provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smiter.Provider.app.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

    User findByUsername(String name);
    
}
