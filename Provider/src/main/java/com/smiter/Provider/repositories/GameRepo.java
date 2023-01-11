package com.smiter.Provider.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smiter.Provider.models.Game;


public interface GameRepo extends JpaRepository<Game, Long>{
}
