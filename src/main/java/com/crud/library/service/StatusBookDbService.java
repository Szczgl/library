package com.crud.library.service;

import com.crud.library.domain.StatusBook;
import com.crud.library.repository.StatusBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusBookDbService {

    @Autowired
    private StatusBookRepository statusBookRepository;

    public List<StatusBook> getAllStatusBook() {
        return statusBookRepository.findAll();
    }

    public StatusBook getStatus(final Long idBook) {
        return statusBookRepository.findById(idBook).orElseThrow();
    }
}
