package org.aton.in_memory_simple_db.storage;


import lombok.Getter;
import org.aton.in_memory_simple_db.models.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Scope(scopeName = "singleton")
@Component
public class UserStorage {

    @Getter
    private static final UserStorage Instance;

    private final List<User> sortedUsersByAccount = new ArrayList<>();

    private final List<User> sortedUsersByName = new ArrayList<>();

    private final List<User> sortedUsersByValue = new ArrayList<>();


    static {
        Instance = new UserStorage();
    }


    private UserStorage() {}

}
