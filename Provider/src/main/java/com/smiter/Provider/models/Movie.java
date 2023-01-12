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
    
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getTitle() {
    	return title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public String getGenre() {
    	return genre;
    }
    public void setGenre(String genre) {
    	this.genre = genre;
    }
    public String getProducer() {
    	return producer;
    }
    public void setProducer(String producer) {
    	this.producer = producer;
    }
    public String getDirector() {
    	return director;
    }
    public void setDirector(String director) {
    	this.director = director;
    }
}
