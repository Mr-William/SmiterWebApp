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

import com.smiter.WebApp.dtos.BookDto;
import com.smiter.WebApp.managers.BookManager;

@Service
public class BookManagerImpl implements BookManager{

    private static final String url = "http://localhost:8085/api/books/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<BookDto> saveBook(BookDto book) {
        return restTemplate.postForEntity(url, book, BookDto.class);
    }

    @Override
    public ResponseEntity<BookDto> getBookById(Long id) {
        return restTemplate.getForEntity(url + "/{title}", BookDto.class);
    }

    @Override
    public ResponseEntity<BookDto> updateBook(Long id, BookDto book) {
        return restTemplate.exchange(url + "/{id}",
        HttpMethod.PUT,
        new HttpEntity<>(book),
        BookDto.class,
        Long.toString(id));
    }

    @Override
    public void deleteBook(Long id) {
        restTemplate.delete(url + "/{id}");
    }

    @Override
    public ResponseEntity<List<BookDto>> getAllBooks() {
        ResponseEntity<BookDto[]> books = restTemplate.getForEntity(url, BookDto[].class);
        List<BookDto> bookList = new ArrayList<>();
        if(books.getBody() != null){
            bookList = Arrays.stream(books.getBody())
            .collect(Collectors.toList());
        }

        return new ResponseEntity<List<BookDto>>(bookList, HttpStatus.OK);
    }
    
}
