package com.smiter.WebApp.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MovieDto {
    
    Long id;
    String title;
    String genre;
    String producer;
    String director;
}
