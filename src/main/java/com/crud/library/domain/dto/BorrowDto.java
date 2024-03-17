package com.crud.library.domain.dto;

import com.crud.library.domain.StatusBook;
import com.crud.library.domain.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDto {

    private Long id;
    private User user;
    private StatusBook statusBook;
    private Date borrowed;
    private Date returned;
}
