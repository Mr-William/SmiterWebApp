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

import com.smiter.Provider.dtos.GameDto;
import com.smiter.Provider.models.Game;
import com.smiter.Provider.services.GameService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/games/")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable("id") Long id){
        Game game = gameService.getById(id);

        if(game != null){
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        else{
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameService.getAllGames();
        if(games.isEmpty()){
            return new ResponseEntity<>(games, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Game> saveGame(@RequestBody GameDto game){
        System.out.println("Game Title:" + game.getTitle());
        Game ret = gameService.addGame(game);
        return new ResponseEntity<Game>(ret, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") Long id, @RequestBody GameDto game){

        return new ResponseEntity<>(gameService.updateGame(id, game), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<GameDto> deleteGame(@PathVariable("id") Long id){
        
        if(gameService.getById(id) != null){
            gameService.deleteGame(id);
            return new ResponseEntity<GameDto>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
