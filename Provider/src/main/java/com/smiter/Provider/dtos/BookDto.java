package com.smiter.Provider.dtos;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BookDto {
    
    private Long id;
    private String title;
    private String author;
    private String genre;
    private LocalDate datecompleted;
}
