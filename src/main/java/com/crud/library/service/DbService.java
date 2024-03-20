package com.crud.library.service;

import com.crud.library.domain.*;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.BorrowRepository;
import com.crud.library.repository.StatusBookRepository;
import com.crud.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private StatusBookRepository statusBookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public List<StatusBook> getAllStatusBook() {
        return statusBookRepository.findAll();
    }

    public List<Borrow> getAllBorrow() {
        return borrowRepository.findAll();
    }

    public StatusBook getStatus(final Long idBook) {
        return statusBookRepository.findById(idBook).orElseThrow();
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }

    public void deleteBook(final Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
