package com.smiter.Provider.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smiter.Provider.dtos.MovieDto;
import com.smiter.Provider.models.Movie;
import com.smiter.Provider.services.MovieService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/movies/")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id){
        Movie movie = movieService.getById(id);

        if(movie != null){
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        else{
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        if(movies.isEmpty()){
            return new ResponseEntity<>(movies, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Movie> saveMovie(@RequestBody MovieDto movie){
        System.out.println("Movie Title:" + movie.getTitle());
        Movie ret = movieService.addMovie(movie);
        return new ResponseEntity<Movie>(ret, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody MovieDto movie){

        return new ResponseEntity<>(movieService.updateMovie(id, movie), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> deleteMovie(@PathVariable("id") Long id){
        
        if(movieService.getById(id) != null){
            movieService.deleteMovie(id);
            return new ResponseEntity<MovieDto>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
