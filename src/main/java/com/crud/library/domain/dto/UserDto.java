package com.crud.library.domain.dto;

import com.crud.library.domain.Borrow;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Date createdAccount;
}
