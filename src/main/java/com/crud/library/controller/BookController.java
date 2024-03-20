package com.crud.library.controller;


import com.crud.library.domain.*;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/books")
@RequiredArgsConstructor
public class BookController {

    private final BookDbService bookDbService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBook() {
        List<Book> books = bookDbService.getAllBook();
        return ResponseEntity.ok(bookMapper.mapToBookDtoList(books));
    }

    @DeleteMapping(value = "{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookDbService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = bookDbService.saveBook(book);
        return ResponseEntity.ok(bookMapper.mapToBookDto(savedBook));
    }
}
