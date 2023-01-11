package com.smiter.WebApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.smiter.WebApp.dtos.MovieDto;
import com.smiter.WebApp.managers.MovieManager;

@Controller
public class MovieController {

    @Autowired
    private MovieManager manager;

    private TableHeaders headers = new TableHeaders();
    private List<String> tbl = new ArrayList<>();

    @GetMapping("/movies")
    public ModelAndView getMovies(){
        tbl = headers.getMovieHeaders();
        List<MovieDto> movieList = manager.getAllMovies().getBody();
        List<MovieDto> movies = new ArrayList<>();
        MovieDto movie = new MovieDto();
        for(MovieDto g : movieList){
            movie.setGenre(g.getGenre());
            movie.setTitle(g.getTitle());
            movie.setProducer(g.getProducer());
            movie.setDirector(g.getDirector());

            movies.add(movie);
        }

        return new ModelAndView("movielisting", "reviews", movies)
        .addObject("message", "Movies")
        .addObject("title", "Movies Page")
        .addObject("tableHeaders", tbl);
    }

    @GetMapping("/addmovie")
    public ModelAndView addMovie(){
        return new ModelAndView("moviecreate", "MovieDto", new MovieDto());
    }
}
