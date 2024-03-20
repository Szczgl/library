package com.crud.library.controller;

import com.crud.library.domain.Borrow;
import com.crud.library.domain.dto.BorrowDto;
import com.crud.library.mapper.BorrowMapper;
import com.crud.library.service.BorrowDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/borrow")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowDbService borrowDbService;
    private final BorrowMapper borrowMapper;

    @GetMapping
    public ResponseEntity<List<BorrowDto>> getAllBorrows() {
        List<Borrow> borrows = borrowDbService.getAllBorrow();
        List<BorrowDto> borrowDtos = borrowMapper.mapToBorrowDtoList(borrows);
        return ResponseEntity.ok(borrowDtos);
    }
}
