package com.smiter.Provider.services;

import java.util.List;

import com.smiter.Provider.models.Book;

public interface BookService {
    
    public Book addBook(Book book);
    public List<Book> getAllBooks();
    public Book getById(Long id);
    public Book updateBook(Long bookId, Book book);
    public String deleteBook(Long bookId);
}

