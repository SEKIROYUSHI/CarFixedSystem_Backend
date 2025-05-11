package com.carSys.Service;

import com.carSys.Entity.RepairPerson;
import com.carSys.Enums.TaskType;
import com.carSys.Mapper.RepairPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairPersonService {
    @Autowired
    private RepairPersonMapper repairPersonMapper;

    // 创建维修人员
    public boolean createRepairPerson(RepairPerson repairPerson) {
        return repairPersonMapper.insertRepairPerson(repairPerson) > 0;
    }

    // 查询维修人员详情
    public RepairPerson getRepairPersonById(long repair_person_id) {
        return repairPersonMapper.selectRepairPersonById(repair_person_id);
    }

    // 根据用户ID查询维修人员
    public RepairPerson getRepairPersonByUserId(long user_id) {
        return repairPersonMapper.selectRepairPersonByUserId(user_id);
    }

    // 更新维修人员信息
    public boolean updateRepairPerson(RepairPerson repairPerson) {
        return repairPersonMapper.updateRepairPerson(repairPerson) > 0;
    }

    // 删除维修人员
    public boolean deleteRepairPerson(long repair_person_id) {
        return repairPersonMapper.deleteRepairPerson(repair_person_id) > 0;
    }

    public List<RepairPerson> getRepairPersonBySpecialty(TaskType specialty) {
        return repairPersonMapper.selectRepairPersonBySpecialty(specialty);
    }
}