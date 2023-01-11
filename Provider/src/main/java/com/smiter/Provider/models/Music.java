package com.smiter.Provider.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MUSIC")
@Getter
@Setter
public class Music {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MUSIC_ID")
    private Long id;

    @Column(name = "SONG_TITLE", nullable = false)
    private String songTitle;

    @Column(name = "ALBUM_TITLE")
    private String albumTitle;

    @Column(name = "SONG_ARTIST", nullable = false)
    private String artist;

    @Column(name = "SONG_GENRE")
    private String genre;
}
