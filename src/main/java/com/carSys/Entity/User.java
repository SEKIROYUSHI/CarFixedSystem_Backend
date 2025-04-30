package com.carSys.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    long user_id;
    String username;
    String password;
    String userRole;


    public User(String username, String password,String userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
}