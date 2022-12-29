package com.smiter.Provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smiter.Provider.app.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{
    
}