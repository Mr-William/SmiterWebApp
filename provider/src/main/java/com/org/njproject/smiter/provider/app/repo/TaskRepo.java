package com.org.njproject.smiter.provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.njproject.smiter.provider.app.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{
    
}