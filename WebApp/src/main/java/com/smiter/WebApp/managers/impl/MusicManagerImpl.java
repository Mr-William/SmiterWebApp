package com.smiter.WebApp.managers.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smiter.WebApp.dtos.MusicDto;
import com.smiter.WebApp.managers.MusicManager;

@Service
public class MusicManagerImpl implements MusicManager{

    private static final String url = "http://localhost:8085/api/musics/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<MusicDto> saveMusic(MusicDto music) {
        return restTemplate.postForEntity(url, music, MusicDto.class);
    }

    @Override
    public ResponseEntity<MusicDto> getMusicById(Long id) {
        return restTemplate.getForEntity(url + "/{id}", MusicDto.class);
    }

    @Override
    public ResponseEntity<MusicDto> updateMusic(Long id, MusicDto music) {
        return restTemplate.exchange(url + "/{id}",
        HttpMethod.PUT,
        new HttpEntity<>(music),
        MusicDto.class,
        Long.toString(id));
    }

    @Override
    public void deleteMusic(Long id) {
        restTemplate.delete(url + "/{id}");        
    }

    @Override
    public ResponseEntity<List<MusicDto>> getAllMusic() {
        ResponseEntity<MusicDto[]> music = restTemplate.getForEntity(url, MusicDto[].class);
        List<MusicDto> musicList = new ArrayList<>();
        if(music.getBody() != null){
            musicList = Arrays.stream(music.getBody())
            .collect(Collectors.toList());
        }

        return new ResponseEntity<List<MusicDto>>(musicList, HttpStatus.OK);
    }
    
}
