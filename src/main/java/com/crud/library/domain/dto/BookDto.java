package com.crud.library.domain.dto;

import com.crud.library.domain.StatusBook;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private int year;
}
