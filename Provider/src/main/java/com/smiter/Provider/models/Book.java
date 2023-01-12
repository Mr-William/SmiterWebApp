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
@Table(name="BOOKS")
@Getter
@Setter
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "BOOK_TITLE", nullable = false)
    private String title;

    @Column(name = "BOOK_AUTHOR", nullable = false)
    private String author;

    @Column(name = "BOOK_GENRE")
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
    // public String getAuthor() {
    // 	return author;
    // }
    // public void setAuthor(String author) {
    // 	this.author = author;
    // }
    // public String getGenre() {
    // 	return genre;
    // }
    // public void setGenre(String genre) {
    // 	this.genre = genre;
    // }
    // public LocalDate getDatecompleted() {
    // 	return datecompleted;
    // }
    // public void setDateCompleted(LocalDate date) {
    // 	this.datecompleted = date;
    // }
}
