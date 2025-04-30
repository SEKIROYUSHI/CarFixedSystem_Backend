package com.carSys.Controller;

import com.carSys.Entity.User;
import com.carSys.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 根据用户 ID 查询用户
    @GetMapping("/getUserById/{user_id}")
    public User getUserById(@PathVariable long user_id) {
        return userService.getUserById(user_id);
    }

    // 查询所有用户
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 插入新用户
    @PostMapping("/addNewUser")
    public int addNewUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // 根据用户 ID 更新用户信息
    @PutMapping("/updateUser")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // 根据用户 ID 删除用户
    @DeleteMapping("/deleteUser/{user_id}")
    public int deleteUser(@PathVariable long user_id) {
        return userService.deleteUser(user_id);
    }

    // 用户登录接口
    @PostMapping("/logIn")
    public boolean logIn(@RequestBody User user) {
        // 这里简单模拟登录逻辑，实际应用中需要根据业务需求完善
        User storedUser = userService.getUserByUserName(user.getUsername());
        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}