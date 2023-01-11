package com.smiter.Provider.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smiter.Provider.models.Music;

public interface MusicRepo extends JpaRepository<Music, Long>{
 
    List<Music> findBySongTitle(String songTitle);
    List<Music> findByAlbumTitle(String albumTitle);
}
