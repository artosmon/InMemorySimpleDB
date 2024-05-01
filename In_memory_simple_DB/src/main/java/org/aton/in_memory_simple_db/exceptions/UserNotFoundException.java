package org.aton.in_memory_simple_db.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("user named " + username + " was not found");
    }

    public UserNotFoundException(long id) {
        super("user with id/account " + id + " was not found");
    }

    public UserNotFoundException(double value) {
        super("user with value " + value + " was not found");
    }
}
