package com.smiter.Provider.services;

import java.util.List;

import com.smiter.Provider.dtos.MovieDto;
import com.smiter.Provider.models.Movie;

public interface MovieService {
    
    public Movie addMovie(MovieDto movieDto);
    public List<Movie> getAllMovies();
    public Movie getById(Long id);
    public Movie updateMovie(Long bookId, MovieDto movie);
    public String deleteMovie(Long movieId);
    
}
