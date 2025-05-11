package com.carSys.Entity;

import com.carSys.Enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairPerson {
    private long repair_person_id; // 维修人员ID（主键）
    private long user_id;          // 用户ID（外键）
    private List<TaskType> specialty;      // 专业技能，逗号分隔
    private double hourly_rate;    // 每小时费率
}