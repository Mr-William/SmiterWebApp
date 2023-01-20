package com.smiter.Provider.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Music addMusic(Music tmp) {
		return musicRepo.save(tmp);
	}

	@Override
	public Music getById(Long id) {
		return musicRepo.getById(id);
	}

	@Override
	public Music updateMusic(Long id, Music tmp) {

		Music ms = new Music();
        ms.setTitle(tmp.getTitle());
        ms.setAlbum(tmp.getAlbum());
        ms.setArtist(tmp.getArtist());
        ms.setGenre(tmp.getGenre());
        ms.setId(id);

		return musicRepo.save(ms);
	}

    @Override
    public List<Music> getAllMusic() {
        return musicRepo.findAll();
    }

    @Override
    public String deleteMusic(Long musicId) {
            musicRepo.deleteById(musicId);
            return "Book with id " + musicId + " successfully deleted";
    }

}
