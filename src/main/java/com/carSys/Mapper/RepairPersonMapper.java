package com.carSys.Mapper;

import com.carSys.Entity.RepairPerson;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepairPersonMapper {
    // 插入维修人员信息
    int insertRepairPerson(RepairPerson repairPerson);

    // 根据维修人员ID查询
    RepairPerson selectRepairPersonById(long repair_person_id);

    // 根据用户ID查询
    RepairPerson selectRepairPersonByUserId(long user_id);

    // 更新维修人员信息
    int updateRepairPerson(RepairPerson repairPerson);

    // 删除维修人员（逻辑或物理）
    int deleteRepairPerson(long repair_person_id);
}