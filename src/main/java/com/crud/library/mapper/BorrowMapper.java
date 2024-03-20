package com.crud.library.mapper;

import com.crud.library.domain.Borrow;
import com.crud.library.domain.dto.BorrowDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BorrowMapper {

    public BorrowDto mapToBorrowDto (final Borrow borrow) {
        return new BorrowDto(borrow.getId(), borrow.getUser(), borrow.getStatusBook(),borrow.getBorrowed(),borrow.getReturned());
    }

    public List<BorrowDto> mapToBorrowDtoList(List<Borrow> borrowList) {
        return borrowList.stream()
                .map(this::mapToBorrowDto)
                .toList();
    }

}
