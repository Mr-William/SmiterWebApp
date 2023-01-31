package com.smiter.Provider.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.models.Book;
import com.smiter.Provider.repositories.BookRepo;
import com.smiter.Provider.services.BookService;

import jakarta.transaction.Transactional;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Override
	@Transactional
	public Book addBook(Book save) {
        return bookRepo.save(save);
	}

	@Override
	public Book getById(Long id) {
		return bookRepo.getById(id);
	}

	@Override
	public Book updateBook(Long id, Book tmp) {

		Book bk = new Book();
        
        bk.setTitle(tmp.getTitle());
        bk.setAuthor(tmp.getAuthor());
        bk.setGenre(tmp.getGenre());
        bk.setDatecompleted(tmp.getDatecompleted());
        bk.setId(id);

		return bookRepo.save(bk);
	}

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public String deleteBook(Long bookId) {
    	
            bookRepo.deleteById(bookId);
            return "Book with id " + bookId + " successfully deleted";
    }

}
