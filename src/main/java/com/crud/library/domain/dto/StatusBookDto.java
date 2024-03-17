package com.crud.library.domain.dto;

import com.crud.library.domain.Book;
import com.crud.library.domain.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusBookDto {

    private Long id;
    private Book idBook;
    private Status status;
}
