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

import com.smiter.Provider.dtos.MusicDto;
import com.smiter.Provider.models.Music;
import com.smiter.Provider.services.MusicService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/musics/")
public class MusicController {
    
    @Autowired
    private MusicService musicService;

    @GetMapping("/{id}")
    public ResponseEntity<Music> getMusic(@PathVariable("id") Long id){
        Music music = musicService.getById(id);

        if(music != null){
            return new ResponseEntity<>(music, HttpStatus.OK);
        }
        else{
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Music>> getAllMusics(){
        List<Music> musics = musicService.getAllMusic();
        if(musics.isEmpty()){
            return new ResponseEntity<>(musics, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Music>>(musics, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Music> saveMusic(@RequestBody MusicDto music){
        Music ret = musicService.addMusic(music);
        return new ResponseEntity<Music>(ret, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable("id") Long id, @RequestBody MusicDto music){

        return new ResponseEntity<>(musicService.updateMusic(id, music), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<MusicDto> deleteMusic(@PathVariable("id") Long id){
        
        if(musicService.getById(id) != null){
            musicService.deleteMusic(id);
            return new ResponseEntity<MusicDto>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
