package com.smiter.Provider.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smiter.Provider.dtos.BookDto;
import com.smiter.Provider.models.Book;
import com.smiter.Provider.services.BookService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/books/")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id){
        Book book = bookService.getById(id);

        if(book != null){
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        else{
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        if(books.isEmpty()){
            return new ResponseEntity<>(books, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Book> saveBook(@RequestBody BookDto book){
        Book ret = bookService.addBook(book);
        return new ResponseEntity<Book>(ret, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody BookDto book){

        return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable("id") Long id){
        
        if(bookService.getById(id) != null){
            bookService.deleteBook(id);
            return new ResponseEntity<BookDto>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
