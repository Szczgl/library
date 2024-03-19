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

import java.util.List;

@Component
public class LibraryMapper {

    public BookDto mapToBookDto (final Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
    }

    public UserDto mapToUserDto (final User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getCreatedAccount());
    }

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYear());
    }

    public User mapToUser(final UserDto  userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getCreatedAccount());
    }

    public StatusBookDto mapToStatusBookDto (final StatusBook statusBook) {
        return new StatusBookDto(statusBook.getId(),statusBook.getBook(), statusBook.getStatus());
    }

    public BorrowDto mapToBorrowDto (final Borrow borrow) {
        return new BorrowDto(borrow.getId(), borrow.getUser(), borrow.getStatusBook(),borrow.getBorrowed(),borrow.getReturned());
    }

    public List<UserDto> mapToUserDtoList (final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .toList();
    }

    public List<BookDto> mapToBookDtoList (final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .toList();
    }

    public List<BorrowDto> mapToBorrowDtoList(List<Borrow> borrowList) {
        return borrowList.stream()
                .map(this::mapToBorrowDto)
                .toList();
    }

    public List<StatusBookDto> mapToStatusBookDtoList(List<StatusBook> statusBookList) {
        return statusBookList.stream()
                .map(this::mapToStatusBookDto)
                .toList();
    }

}
