package com.smiter.Provider.dtos;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class GameDto {
    
    Long id;
    String title;
    String genre;
    LocalDate datecompleted;
}
