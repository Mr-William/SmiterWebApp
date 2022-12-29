package com.smiter.Provider.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smiter.Provider.app.model.GroupUser;

public interface GroupUserRepo extends JpaRepository<GroupUser, Long>{
    
}
