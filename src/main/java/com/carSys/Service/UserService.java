package com.carSys.Service;

import com.carSys.Entity.User;
import com.carSys.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User getUserById(long user_id) {
        return userMapper.selectUserById(user_id);
    }


    public User getUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }

    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    public int addUser(User user) {
        return userMapper.addNewUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUser(long user_id) {
        return userMapper.deleteUser(user_id);
    }
}