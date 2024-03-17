package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.Borrow;
import com.crud.library.domain.StatusBook;
import com.crud.library.domain.User;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BorrowDto;
import com.crud.library.domain.dto.StatusBookDto;
import com.crud.library.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYear());
    }

    public BookDto mapToBookDto (final Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
    }

    public User mapToUser(final UserDto  userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName());
    }

    public UserDto mapToUserDto (final User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getCreatedAccount());
    }

    public StatusBookDto mapToStatusBookDto (final StatusBook statusBook) {
        return new StatusBookDto(statusBook.getId(), statusBook.getBook(), statusBook.getStatus());
    }

    public BorrowDto mapToBorrowDto (final Borrow borrow) {
        return new BorrowDto(borrow.getId(), borrow.getUser(), borrow.getStatusBook(),borrow.getBorrowed(),borrow.getReturned());
    }

}
