package com.smiter.WebApp.managers.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smiter.WebApp.dtos.MovieDto;
import com.smiter.WebApp.managers.MovieManager;

@Service
public class MovieManagerImpl implements MovieManager{

    private static final String url = "http://localhost:8085/api/movies/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<MovieDto> saveMovie(MovieDto movie) {
        return restTemplate.postForEntity(url, movie, MovieDto.class);
    }

    @Override
    public ResponseEntity<MovieDto> getMovieById(Long id) {
        return restTemplate.getForEntity(url + "/{id}", MovieDto.class);
    }

    @Override
    public ResponseEntity<MovieDto> updateMovie(Long id, MovieDto movie) {
        return restTemplate.exchange(url + "/{id}",
        HttpMethod.PUT,
        new HttpEntity<>(movie),
        MovieDto.class,
        Long.toString(id));
    }

    @Override
    public void deleteMovie(Long id) {
        restTemplate.delete(url + "/{id}");
    }

    @Override
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        ResponseEntity<MovieDto[]> movies = restTemplate.getForEntity(url, MovieDto[].class);
        List<MovieDto> movieList = new ArrayList<>();
        if(movies.getBody() != null){
            movieList = Arrays.stream(movies.getBody())
            .collect(Collectors.toList());
        }

        return new ResponseEntity<List<MovieDto>>(movieList, HttpStatus.OK);
    }
    
}
