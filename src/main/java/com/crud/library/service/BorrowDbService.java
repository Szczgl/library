package com.crud.library.service;

import com.crud.library.domain.Borrow;
import com.crud.library.repository.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowDbService {

    @Autowired
    private BorrowRepository borrowRepository;

    public List<Borrow> getAllBorrow() {
        return borrowRepository.findAll();
    }
}
