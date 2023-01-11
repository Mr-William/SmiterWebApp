package com.smiter.WebApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.smiter.WebApp.dtos.BookDto;
import com.smiter.WebApp.managers.BookManager;

@Controller
public class BookController {

    @Autowired
    private BookManager bookManager;

    private TableHeaders headers = new TableHeaders();
    private List<String> tbl = new ArrayList<>();

    @GetMapping("/books")
    public ModelAndView getBooks(){
        tbl = headers.getBookHeaders();
        List<BookDto> bookList = bookManager.getAllBooks().getBody();
        List<BookDto> books = new ArrayList<>();
        BookDto book = new BookDto();
        for(BookDto b : bookList){
            book.setAuthor(b.getAuthor());
            book.setGenre(b.getGenre());
            book.setTitle(b.getTitle());
            book.setDatecompleted(b.getDatecompleted());
            System.out.println("Date completed: " + book.getDatecompleted());

            books.add(book);
        }

        return new ModelAndView("booklisting", "reviews", books)
        .addObject("message", "Books")
        .addObject("title", "Book Page")
        .addObject("tableHeaders", tbl);
    }

    @GetMapping("/addbook")
    public ModelAndView addBook(){
        return new ModelAndView("bookcreate", "BookDto", new BookDto());
    }
}
