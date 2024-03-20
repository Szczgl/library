package com.crud.library.controller;

import com.crud.library.domain.StatusBook;
import com.crud.library.domain.dto.StatusBookDto;
import com.crud.library.mapper.StatusBookMapper;
import com.crud.library.service.StatusBookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/status")
@RequiredArgsConstructor
public class StatusBookController {

    private final StatusBookDbService statusBookDbService;
    private final StatusBookMapper statusBookMapper;

    @GetMapping("{id}")
    public ResponseEntity<StatusBookDto> getStatus(@PathVariable Long id) {
        return ResponseEntity.ok(statusBookMapper.mapToStatusBookDto(statusBookDbService.getStatus(id)));
    }

    @GetMapping
    public ResponseEntity<List<StatusBookDto>> getStatus() {
        List<StatusBook> statusBooks = statusBookDbService.getAllStatusBook();
        return ResponseEntity.ok(statusBookMapper.mapToStatusBookDtoList(statusBooks));
    }
}
