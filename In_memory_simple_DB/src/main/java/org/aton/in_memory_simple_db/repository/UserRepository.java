package org.aton.in_memory_simple_db.repository;

import org.aton.in_memory_simple_db.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    void save(User user);
    User update(User user);

    List<User> findAll();

    Optional<User> findByName(String username);

    Optional<User> findByAccount(long account);

    void delete(User user);

    Optional<User> findByValue(double value);

}
