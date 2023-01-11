package com.smiter.WebApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.smiter.WebApp.dtos.MusicDto;
import com.smiter.WebApp.managers.MusicManager;

@Controller
public class MusicController {

    @Autowired
    private MusicManager manager;

    private TableHeaders headers = new TableHeaders();
    private List<String> tbl = new ArrayList<>();

    @GetMapping("/musics")
    public ModelAndView getMusics(){
        tbl = headers.getMusicHeaders();
        List<MusicDto> musicList = manager.getAllMusic().getBody();
        List<MusicDto> musics = new ArrayList<>();
        MusicDto music = new MusicDto();
        for(MusicDto g : musicList){
            music.setGenre(g.getGenre());
            music.setAlbumTitle(g.getAlbumTitle());
            music.setArtist(g.getArtist());
            music.setSongTitle(g.getSongTitle());

            musics.add(music);
        }

        return new ModelAndView("musiclisting", "reviews", musics)
        .addObject("message", "Musics")
        .addObject("title", "Musics Page")
        .addObject("tableHeaders", tbl);
    }

    @GetMapping("/addmusic")
    public ModelAndView addMusic(){
        return new ModelAndView("musiccreate", "MusicDto", new MusicDto());
    }
}
