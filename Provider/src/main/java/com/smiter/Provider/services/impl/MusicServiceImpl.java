package com.smiter.Provider.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.dtos.MusicDto;
import com.smiter.Provider.models.Music;
import com.smiter.Provider.repositories.MusicRepo;
import com.smiter.Provider.services.MusicService;

import jakarta.transaction.Transactional;

@Service
public class MusicServiceImpl implements MusicService{

	@Autowired
	private MusicRepo musicRepo;

	@Override
	@Transactional
	public Music addMusic(MusicDto musicDto) {

		Music ms = new Music();
        ms.setSongTitle(musicDto.getSongTitle());
        ms.setAlbumTitle(musicDto.getAlbumTitle());
        ms.setArtist(musicDto.getArtist());
        ms.setGenre(musicDto.getGenre());

		return musicRepo.save(ms);
	}

	@Override
	public Music getById(Long id) {
		return musicRepo.findById(id).get();
	}

	@Override
	public Music updateMusic(Long id, MusicDto musicDto) {

		Music ms = new Music();
        ms.setSongTitle(musicDto.getSongTitle());
        ms.setAlbumTitle(musicDto.getAlbumTitle());
        ms.setArtist(musicDto.getArtist());
        ms.setGenre(musicDto.getGenre());
        ms.setId(id);

		return musicRepo.save(ms);
	}

    @Override
    public List<Music> getAllMusic() {
        return musicRepo.findAll();
    }

    @Override
    public String deleteMusic(Long musicId) {
        if(musicRepo.findById(musicId) != null){
            musicRepo.deleteById(musicId);
            return "Book with id " + musicId + " successfully deleted";
        }else{
            return "Book with id " + musicId + " could not be found";
        }
    }

}
