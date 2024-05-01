package org.aton.in_memory_simple_db.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    long account;
    String name;
    double value;


}
