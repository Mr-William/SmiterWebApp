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
}
