package com.crud.library.controller;


import com.crud.library.domain.*;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BorrowDto;
import com.crud.library.domain.dto.StatusBookDto;
import com.crud.library.domain.dto.UserDto;
import com.crud.library.mapper.LibraryMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
public class LibraryController {

    private final DbService dbService;
    private final LibraryMapper libraryMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUser() {
        List<User> users = dbService.getAllUser();
        return ResponseEntity.ok(libraryMapper.mapToUserDtoList(users));
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBook() {
        List<Book> books = dbService.getAllBook();
        return ResponseEntity.ok(libraryMapper.mapToBookDtoList(books));
    }

    @GetMapping("{id}")
    public ResponseEntity<StatusBookDto> getStatus(@PathVariable Long id) {
        return ResponseEntity.ok(libraryMapper.mapToStatusBookDto(dbService.getStatus(id)));
    }
//  @GetMapping("{status/idBook}")
//    public ResponseEntity<List<StatusBookDto>> getAllStatusBooks(@PathVariable Long idBook) {
//        List<StatusBook> statusBooks = dbService.getAllStatusBook();
//        List<StatusBookDto> statusBookDtos = libraryMapper.mapToStatusBookDtoList(statusBooks);
//        return ResponseEntity.ok(statusBookDtos);
//    }
// @GetMapping("{status}")
//    public ResponseEntity<List<StatusBookDto>> getStatus() {
//        List<StatusBook> statusBooks = dbService.getAllStatusBook();
//        return ResponseEntity.ok(libraryMapper.mapToStatusBookDtoList(statusBooks));
//    }

//    @GetMapping("/borrows")
//    public ResponseEntity<List<BorrowDto>> getAllBorrows() {
//        List<Borrow> borrows = dbService.getAllBorrow();
//        List<BorrowDto> borrowDtos = libraryMapper.mapToBorrowDtoList(borrows);
//        return ResponseEntity.ok(borrowDtos);
//    }
}
