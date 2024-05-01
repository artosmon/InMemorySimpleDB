package org.aton.in_memory_simple_db.exceptions;

public class UserAccountUniqueException extends RuntimeException {
    public UserAccountUniqueException(long account) {
        super("User account: " + account + " already exists");
    }
}
