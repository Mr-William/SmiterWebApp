package com.smiter.Provider.services;

import java.util.List;

import com.smiter.Provider.dtos.BookDto;
import com.smiter.Provider.models.Book;

public interface BookService {
    
    public Book addBook(BookDto bookDto);
    public List<Book> getAllBooks();
    public Book getById(Long id);
    public Book updateBook(Long bookId, BookDto book);
    public String deleteBook(Long bookId);
}
