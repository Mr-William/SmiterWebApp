package com.smiter.Provider.services;

import java.util.List;

import com.smiter.Provider.dtos.GameDto;
import com.smiter.Provider.models.Game;

public interface GameService {
    
    public Game addGame(Game game);
    public List<Game> getAllGames();
    public Game getById(Long id);
    public Game updateGame(Long gameId, Game game);
    public String deleteGame(Long gameId);
    
}
