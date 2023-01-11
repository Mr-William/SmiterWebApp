package com.smiter.WebApp.managers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.smiter.WebApp.dtos.MusicDto;

public interface MusicManager {
    
    ResponseEntity<List<MusicDto>> getAllMusic();
    ResponseEntity<MusicDto> saveMusic(MusicDto music);
    ResponseEntity<MusicDto> getMusicById(Long id);
    ResponseEntity<MusicDto> updateMusic(Long id, MusicDto music);
    void deleteMusic(Long id);
}
