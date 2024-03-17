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

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Book saveBook (Book book) {
        return bookRepository.save(book);
    }

    public StatusBook addCopy(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Brak takiej pozycji"));

        StatusBook statusBook = new StatusBook();
        statusBook.setBook(book);
        statusBook.setStatus(Status.AVAILABLE);
        return statusBookRepository.save(statusBook);
    }

    public StatusBook changeCopyStatus(Long copyId, Status status) {
        StatusBook statusBook = statusBookRepository.findById(copyId)
                .orElseThrow(() -> new IllegalArgumentException("Brak takiej pozycji"));

        statusBook.setStatus(status);
        return statusBookRepository.save(statusBook);
    }

    public int getAvailableCopiesCount(Long bookId) {
        return statusBookRepository.countByBookIdAndStatus(bookId, Status.AVAILABLE);
    }

    public Borrow borrowBook(Long copyId, Long userId) {
        StatusBook statusBook = statusBookRepository.findById(copyId)
                .orElseThrow(() -> new IllegalArgumentException("Brak takiej pozycji"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Brak takiej pozycji"));

        if (statusBook.getStatus() != Status.AVAILABLE) {
            throw new IllegalStateException("Brak dostępności tej książki");
        }

        statusBook.setStatus(Status.LOST);

        Borrow borrow = new Borrow();
        borrow.setStatusBook(statusBook);
        borrow.setUser(user);
        borrow.setBorrowed(new Date());

        return borrowRepository.save(borrow);
    }

    public Borrow returnBook(Long borrowId) {
        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new IllegalArgumentException("Nie wypożyczono takej książki"));

        StatusBook statusBook = borrow.getStatusBook();
        statusBook.setStatus(Status.AVAILABLE);
        statusBookRepository.save(statusBook);

        borrow.setReturned(new Date());
        return borrowRepository.save(borrow);
    }
}
