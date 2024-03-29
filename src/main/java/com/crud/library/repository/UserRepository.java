package com.crud.library.repository;

import com.crud.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);
}
