package com.smiter.Provider.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.dtos.BookDto;
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
	public Book addBook(BookDto bookDto) {

        Book bk = new Book();

        bk.setTitle(bookDto.getTitle());
        bk.setAuthor(bookDto.getAuthor());
        bk.setGenre(bookDto.getGenre());
        bk.setDatecompleted(bookDto.getDatecompleted());
        return bookRepo.save(bk);
	}

	@Override
	public Book getById(Long id) {
		return bookRepo.findById(id).get();
	}

	@Override
	public Book updateBook(Long id, BookDto bookDto) {

		Book bk = new Book();
        
        bk.setTitle(bookDto.getTitle());
        bk.setAuthor(bookDto.getAuthor());
        bk.setGenre(bookDto.getGenre());
        bk.setDatecompleted(bookDto.getDatecompleted());
        bk.setId(id);

		return bookRepo.save(bk);
	}

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public String deleteBook(Long bookId) {
        if(bookRepo.findById(bookId) != null){
            bookRepo.deleteById(bookId);
            return "Book with id " + bookId + " successfully deleted";
        }else{
            return "Book with id " + bookId + " could not be found";
        }
    }

}
