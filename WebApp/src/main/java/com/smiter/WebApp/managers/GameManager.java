package com.smiter.WebApp.managers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.smiter.WebApp.dtos.GameDto;

public interface GameManager {

    ResponseEntity<List<GameDto>> getAllGames();    
    ResponseEntity<GameDto> saveGame(GameDto game);
    ResponseEntity<GameDto> getGameById(Long id);
    ResponseEntity<GameDto> updateGame(Long id, GameDto book);
    void deleteGame(Long id);
}
