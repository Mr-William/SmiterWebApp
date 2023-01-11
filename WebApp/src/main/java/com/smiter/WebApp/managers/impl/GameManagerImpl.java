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

import com.smiter.WebApp.dtos.GameDto;
import com.smiter.WebApp.managers.GameManager;

@Service
public class GameManagerImpl implements GameManager{

    private static final String url = "http://localhost:8085/api/games/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<GameDto> saveGame(GameDto game) {
        return restTemplate.postForEntity(url, game, GameDto.class);
    }

    @Override
    public ResponseEntity<GameDto> getGameById(Long Id) {
        return restTemplate.getForEntity(url + "/{id}", GameDto.class);
    }

    @Override
    public ResponseEntity<GameDto> updateGame(Long id, GameDto game) {
        return restTemplate.exchange(url + "/{id}",
            HttpMethod.PUT,
            new HttpEntity<>(game),
            GameDto.class,
            Long.toString(id));
    }

    @Override
    public void deleteGame(Long id) {
        restTemplate.delete(url + "{id}");
    }

    @Override
    public ResponseEntity<List<GameDto>> getAllGames() {
        ResponseEntity<GameDto[]> games = restTemplate.getForEntity(url, GameDto[].class);
        List<GameDto> gameList = new ArrayList<>();
        if(games.getBody() != null){
            gameList = Arrays.stream(games.getBody())
            .collect(Collectors.toList());
        }

        return new ResponseEntity<List<GameDto>>(gameList, HttpStatus.OK);
    }
    
}
