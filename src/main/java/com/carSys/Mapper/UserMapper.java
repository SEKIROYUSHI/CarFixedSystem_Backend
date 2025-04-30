package com.carSys.Mapper;

import com.carSys.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 根据用户 ID 查询用户
    User selectUserById(long user_id);

    User selectUserByUserName(String username);
    // 查询所有用户
    List<User> selectAllUsers();
    // 插入新用户
    int insertUser(User user);
    // 根据用户 ID 更新用户信息
    int updateUser(User user);
    // 根据用户 ID 删除用户
    int deleteUser(long user_id);
}