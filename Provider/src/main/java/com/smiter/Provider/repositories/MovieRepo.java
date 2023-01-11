package com.smiter.Provider.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smiter.Provider.models.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{
}
