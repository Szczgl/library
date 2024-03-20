package com.crud.library.mapper;

import com.crud.library.domain.StatusBook;
import com.crud.library.domain.dto.StatusBookDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusBookMapper {

    public StatusBookDto mapToStatusBookDto (final StatusBook statusBook) {
        return new StatusBookDto(statusBook.getId(),statusBook.getBook().getId(), statusBook.getStatus());
    }

    public List<StatusBookDto> mapToStatusBookDtoList(List<StatusBook> statusBookList) {
        return statusBookList.stream()
                .map(this::mapToStatusBookDto)
                .toList();
    }
}
