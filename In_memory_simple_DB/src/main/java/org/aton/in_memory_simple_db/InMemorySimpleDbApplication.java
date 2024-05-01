package org.aton.in_memory_simple_db;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class InMemorySimpleDbApplication {


    public static void main(String[] args) {
        SpringApplication.run(InMemorySimpleDbApplication.class, args);

    }

}
