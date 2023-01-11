package com.smiter.Provider.services;

import java.util.List;

import com.smiter.Provider.dtos.MusicDto;
import com.smiter.Provider.models.Music;

public interface MusicService {
    
    public Music addMusic(MusicDto musicDto);
    public List<Music> getAllMusic();
    public Music getById(Long id);
    public Music updateMusic(Long musicId, MusicDto musicDto);
    public String deleteMusic(Long musicId);
}
