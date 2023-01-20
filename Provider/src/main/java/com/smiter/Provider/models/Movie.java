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
@Table(name="MOVIES")
@Getter
@Setter
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long id;

    @Column(name = "MOVIE_TITLE", nullable = false)
    private String title;

    @Column(name = "MOVIE_GENRE")
    private String genre;

    @Column(name = "MOVIE_PRODUCER")
    private String producer;

    @Column(name = "MOVIE_DIRECTOR")
    private String director;

    @Column(name = "RATING")
    private Float rating;
}
