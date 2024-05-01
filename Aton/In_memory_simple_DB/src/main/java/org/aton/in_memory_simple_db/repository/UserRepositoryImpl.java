package org.aton.in_memory_simple_db.repository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aton.in_memory_simple_db.models.User;
import org.aton.in_memory_simple_db.storage.UserStorage;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class UserRepositoryImpl implements UserRepository {

    UserStorage userStorage = UserStorage.getInstance();

    @Override
    public void save(User user) {

        userStorage.getSortedUsersByName().add(user);
        userStorage.getSortedUsersByAccount().add(user);
        userStorage.getSortedUsersByValue().add(user);

        userStorage.getSortedUsersByName().sort((u1,u2) -> u1.getName().compareTo(u2.getName()));
        userStorage.getSortedUsersByAccount().sort((u1,u2) -> Long.compare(u1.getAccount(),u2.getAccount()));
        userStorage.getSortedUsersByValue().sort((u1,u2) -> Double.compare(u1.getValue(), u2.getValue()));
    }

    @Override
    public User update(User user) {
        delete(user);
        save(user);
        return user;
    }

    @Override
    public Optional<User> findByName(String username) {

        int i = Collections.binarySearch(userStorage.getSortedUsersByName(),
                new User(0,username,0),
                (u1,u2) -> u1.getName().compareTo(u2.getName()));
        if (i < 0) {
            return Optional.empty();
        }
        return Optional.of(userStorage.getSortedUsersByName().get(i));

    }

    @Override
    public List<User> findAll() {
        return userStorage.getSortedUsersByName();
    }


    @Override
    public Optional<User> findByAccount(long account) {

        int i = Collections.binarySearch(userStorage.getSortedUsersByAccount(),
                new User(account,null,0),
                (u1,u2) -> Long.compare(u1.getAccount(),u2.getAccount()));
        if (i < 0) {
            return Optional.empty();
        }
        return Optional.of(userStorage.getSortedUsersByAccount().get(i));
    }

    @Override
    public void delete(User user) {
        userStorage.getSortedUsersByName().remove(user);
        userStorage.getSortedUsersByAccount().remove(user);
        userStorage.getSortedUsersByValue().remove(user);
    }

    @Override
    public Optional<User> findByValue(double value) {
        int i = Collections.binarySearch(userStorage.getSortedUsersByValue(),
                new User(0,null,value),
                (u1,u2) -> Double.compare(u1.getValue(), u2.getValue()));
        if (i < 0) {
            return Optional.empty();
        }
        return Optional.of(userStorage.getSortedUsersByValue().get(i));
    }
}
