package org.aton.in_memory_simple_db.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aton.in_memory_simple_db.exceptions.UserAccountUniqueException;
import org.aton.in_memory_simple_db.exceptions.UserNotFoundException;
import org.aton.in_memory_simple_db.models.User;
import org.aton.in_memory_simple_db.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService {

    UserRepository userRepository;


    public User findByUsername(String username) {
        return userRepository.findByName(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public User findByAccount(long account) {
        return userRepository.findByAccount(account).orElseThrow(() -> new UserNotFoundException(account));

    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        validateAccount(user.getAccount());
        userRepository.save(user);
    }

    public User updateUser(User user) {
         userRepository.update(user);
         return user;
    }
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findByValue(double value) {
        return userRepository.findByValue(value).orElseThrow(() -> new UserNotFoundException(value));
    }

    private void validateAccount(long account) {
        try {
            findByAccount(account);
        } catch (UserNotFoundException e) {
            return;
        }
        throw new UserAccountUniqueException(account);
    }


}
