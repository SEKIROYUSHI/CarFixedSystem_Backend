package com.carSys.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

//import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {
    long id;
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}