package com.crud.library.repository;

import com.crud.library.domain.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {

    @Override
    List<Borrow> findAll();
}
