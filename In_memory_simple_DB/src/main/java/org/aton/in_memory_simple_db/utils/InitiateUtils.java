package org.aton.in_memory_simple_db.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aton.in_memory_simple_db.models.User;
import org.aton.in_memory_simple_db.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class InitiateUtils implements CommandLineRunner {

    UserService userService;


    @Override
    public void run(String... args) {

        userService.saveUser(new User(1234,"max",123.4));
        userService.saveUser(new User(123,"ax",123.4));

        System.out.println(userService.findAll());

//        long startTime = System.currentTimeMillis();
//        userService.delete(new User(1234,"max",123.4));
//
//
//        System.out.println(userService.findByUsername("max"));
//        long finishTime = System.currentTimeMillis();
//        System.out.println("\nвремя работы=" + (finishTime-startTime) + "ms.");

    }
}
