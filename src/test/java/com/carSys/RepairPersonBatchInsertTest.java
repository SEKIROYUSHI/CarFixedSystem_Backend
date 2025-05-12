package com.carSys;

import com.carSys.Entity.RepairPerson;
import com.carSys.Entity.User;
import com.carSys.Enums.TaskType;
import com.carSys.Enums.UserRole;
import com.carSys.Service.RepairPersonService;
import com.carSys.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class RepairPersonBatchInsertTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RepairPersonService repairPersonService;

    @Test
    public void testBatchInsertRepairPersons() {
        // 准备10个测试用户数据
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User(
                    "repairman" + i,
                    "password" + i,
                    UserRole.REPAIR_PERSON // 假设存在REPAIRMAN角色
            );
            users.add(user);
        }

        // 批量插入用户并获取ID
        List<Long> userIds = new ArrayList<>();
        for (User user : users) {
            userService.addUser(user); // 主键自动注入到user对象
            userIds.add(user.getUser_id()); // 从对象获取真实ID
        }


        // 为每个用户创建对应的维修人员记录
        List<RepairPerson> repairPersons = new ArrayList<>();
        TaskType[] specialties = TaskType.values();

        for (int i = 0; i < userIds.size(); i++) {
            RepairPerson rp = new RepairPerson();
            rp.setUser_id(userIds.get(i));
            // 轮流分配不同专业技能
            rp.setSpecialty(specialties[i % specialties.length]);
            rp.setHourly_rate(100 + i * 10);
            repairPersons.add(rp);
        }

        // 批量插入维修人员
        for (RepairPerson rp : repairPersons) {
            System.out.println(repairPersonService.createRepairPerson(rp));
        }

        System.out.println("成功批量插入" + repairPersons.size() + "条维修人员记录");
    }
}