package com.smiter.Provider.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MusicDto {
    
    Long id;
    String title;
    String album;
    String artist;
    String genre;
    Float rating;
}
