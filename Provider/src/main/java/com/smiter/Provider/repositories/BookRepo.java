package com.smiter.Provider.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smiter.Provider.models.Book;

public interface BookRepo extends JpaRepository<Book, Long>{
}
