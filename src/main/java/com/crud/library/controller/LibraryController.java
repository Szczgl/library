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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
public class LibraryController {

    private final DbService dbService;
    private final LibraryMapper libraryMapper;

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        User savedUser = dbService.saveUser(libraryMapper.mapToUser(userDto));
        return ResponseEntity.ok(libraryMapper.mapToUserDto(savedUser));
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        Book savedBook = dbService.saveBook(libraryMapper.mapToBook(bookDto));
        return ResponseEntity.ok(libraryMapper.mapToBookDto(savedBook));
    }

    @PostMapping("/copies")
    public ResponseEntity<StatusBookDto> addCopy(@RequestParam Long bookId) {
        StatusBook statusBook = dbService.addCopy(bookId);
        return ResponseEntity.ok(libraryMapper.mapToStatusBookDto(statusBook));
    }

    @PutMapping("/copies/{copyId}")
    public ResponseEntity<StatusBookDto> changeCopyStatus(@PathVariable Long copyId, @RequestParam Status status) {
        StatusBook updatedStatusBook = dbService.changeCopyStatus(copyId, status);
        return ResponseEntity.ok(libraryMapper.mapToStatusBookDto(updatedStatusBook));
    }

    @GetMapping("/copies/{bookId}/available")
    public ResponseEntity<Integer> getAvailableCopiesCount(@PathVariable Long bookId) {
        int count = dbService.getAvailableCopiesCount(bookId);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/borrow")
    public ResponseEntity<BorrowDto> borrowBook(@RequestParam Long copyId, @RequestParam Long userId) {
        Borrow borrowedBook = dbService.borrowBook(copyId, userId);
        return ResponseEntity.ok(libraryMapper.mapToBorrowDto(borrowedBook));
    }

    @PutMapping("/return/{borrowId}")
    public ResponseEntity<BorrowDto> returnBook(@PathVariable Long borrowId) {
        Borrow returnedBook = dbService.returnBook(borrowId);
        return ResponseEntity.ok(libraryMapper.mapToBorrowDto(returnedBook));
    }
}
