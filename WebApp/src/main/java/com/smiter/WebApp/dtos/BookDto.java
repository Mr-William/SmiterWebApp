package com.smiter.WebApp.dtos;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BookDto {
    
    Long id;
    String title;
    String author;
    String genre;
    LocalDate datecompleted;
}
