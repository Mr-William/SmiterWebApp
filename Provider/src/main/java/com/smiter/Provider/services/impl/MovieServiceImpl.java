package com.smiter.Provider.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.dtos.MovieDto;
import com.smiter.Provider.models.Movie;
import com.smiter.Provider.repositories.MovieRepo;
import com.smiter.Provider.services.MovieService;

import jakarta.transaction.Transactional;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepo movieRepo;

	@Override
	@Transactional
	public Movie addMovie(Movie movieDto) {

		return movieRepo.save(movieDto);
	}

	@Override
	public Movie getById(Long id) {
		return movieRepo.getById(id);
	}

	@Override
	public Movie updateMovie(Long id, Movie movieDto) {

		Movie mv = new Movie();
        mv.setTitle(movieDto.getTitle());
        mv.setGenre(movieDto.getGenre());
        mv.setProducer(movieDto.getProducer());
        mv.setDirector(movieDto.getDirector());
        mv.setId(id);

		return movieRepo.save(mv);
	}

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public String deleteMovie(Long movieId) {
            movieRepo.deleteById(movieId);
            return "Book with id " + movieId + " successfully deleted";
    }

}
