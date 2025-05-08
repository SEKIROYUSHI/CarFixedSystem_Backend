package com.carSys.Entity;

import com.carSys.Enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    long user_id;
    String username;
    String password;
    UserRole userRole;


    public User(String username, String password,UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
}