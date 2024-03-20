package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {

    public BookDto mapToBookDto (final Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
    }

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYear());
    }

    public List<BookDto> mapToBookDtoList (final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .toList();
    }



















}
