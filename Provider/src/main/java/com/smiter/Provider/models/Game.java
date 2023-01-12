package com.smiter.Provider.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="GAMES")
@Getter
@Setter
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    private Long id;
    
    @Column(name = "GAME_TITLE", nullable = false)
    private String title;

    @Column(name = "GAME_GENRE")
    private String genre;

    @Column(name = "DATE_COMPLETED")
    private LocalDate datecompleted;
    
    // public Long getId() {
    // 	return id;
    // }
    // public void setId(Long id) {
    // 	this.id = id;
    // }
    // public String getTitle() {
    // 	return title;
    // }
    // public void setTitle(String title) {
    // 	this.title = title;
    // }
    
    // public String getGenre() {
    // 	return genre;
    // }
    // public void setGenre(String genre) {
    // 	this.genre = genre;
    // }
    // public LocalDate getDateCompleted() {
    // 	return datecompleted;
    // }
    // public void setDateCompleted(LocalDate date) {
    // 	this.datecompleted = date;
    // }
}
