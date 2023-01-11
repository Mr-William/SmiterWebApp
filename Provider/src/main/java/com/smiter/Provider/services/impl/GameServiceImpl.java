package com.smiter.Provider.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.dtos.GameDto;
import com.smiter.Provider.models.Game;
import com.smiter.Provider.repositories.GameRepo;
import com.smiter.Provider.services.GameService;

import jakarta.transaction.Transactional;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepo gameRepo;

	@Override
	@Transactional
	public Game addGame(GameDto gameDto) {

		Game gm = new Game();
        gm.setTitle(gameDto.getTitle());
        gm.setGenre(gameDto.getGenre());
        gm.setDatecompleted(gameDto.getDatecompleted());

		return gameRepo.save(gm);
	}

	@Override
	public Game getById(Long id) {
		return gameRepo.findById(id).get();
	}

	@Override
	public Game updateGame(Long id, GameDto gameDto) {

		Game gm = new Game();
        gm.setTitle(gameDto.getTitle());
        gm.setGenre(gameDto.getGenre());
        gm.setDatecompleted(gameDto.getDatecompleted());
        gm.setId(id);

		return gameRepo.save(gm);
	}

    @Override
    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    @Override
    public String deleteGame(Long gameId) {
        if(gameRepo.findById(gameId) != null){
            gameRepo.deleteById(gameId);
            return "Book with id " + gameId + " successfully deleted";
        }else{
            return "Book with id " + gameId + " could not be found";
        }
    }

}
