package com.crud.library.repository;

import com.crud.library.domain.Status;
import com.crud.library.domain.StatusBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Transactional
@Repository
public interface StatusBookRepository extends CrudRepository<StatusBook, Long> {
    //int countByBookIdAndStatus(Long bookId, Status status);

    @Override
    List<StatusBook> findAll();

    @Override
    Optional<StatusBook> findById(Long bookId);
}
