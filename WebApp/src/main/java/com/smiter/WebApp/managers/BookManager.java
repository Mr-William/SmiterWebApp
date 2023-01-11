package com.smiter.WebApp.managers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.smiter.WebApp.dtos.BookDto;

public interface BookManager {
    
    ResponseEntity<List<BookDto>> getAllBooks();
    ResponseEntity<BookDto> saveBook(BookDto book);
    ResponseEntity<BookDto> getBookById(Long id);
    ResponseEntity<BookDto> updateBook(Long id, BookDto book);
    void deleteBook(Long id);
}
