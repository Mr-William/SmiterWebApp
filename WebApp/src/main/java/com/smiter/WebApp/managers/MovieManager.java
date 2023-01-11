package com.smiter.WebApp.managers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.smiter.WebApp.dtos.MovieDto;

public interface MovieManager {
    
    ResponseEntity<List<MovieDto>> getAllMovies();
    ResponseEntity<MovieDto> saveMovie(MovieDto movie);
    ResponseEntity<MovieDto> getMovieById(Long id);
    ResponseEntity<MovieDto> updateMovie(Long id, MovieDto movie);
    void deleteMovie(Long id);
}
