package com.smiter.WebApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.smiter.WebApp.dtos.GameDto;
import com.smiter.WebApp.managers.GameManager;

@Controller
public class GameController {

    @Autowired
    private GameManager manager;

    private TableHeaders headers = new TableHeaders();
    private List<String> tbl = new ArrayList<>();

    @GetMapping("/games")
    public ModelAndView getGames(){
        tbl = headers.getGameHeaders();
        List<GameDto> gameList = manager.getAllGames().getBody();
        List<GameDto> games = new ArrayList<>();
        GameDto game = new GameDto();
        for(GameDto g : gameList){
            game.setGenre(g.getGenre());
            game.setTitle(g.getTitle());
            game.setDatecompleted(g.getDatecompleted());

            games.add(game);
        }

        return new ModelAndView("gamelisting", "reviews", games)
        .addObject("message", "Games")
        .addObject("title", "Games Page")
        .addObject("tableHeaders", tbl);
    }

    @GetMapping("/addgame")
    public ModelAndView addGame(){
        return new ModelAndView("gamecreate", "GameDto", new GameDto());
    }
}
