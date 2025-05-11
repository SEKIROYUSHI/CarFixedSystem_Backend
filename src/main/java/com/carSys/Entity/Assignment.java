package com.carSys.Entity;

import com.carSys.Enums.AssignmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    private long assignment_id;     // 分配ID
    private long order_id;          // 订单ID（外键）
    private long repair_person_id;  // 维修人员ID（外键）
    private AssignmentStatus status;  // 分配状态（如"已指派"、"已完成"）
    private String task_type;
    private int hours_worked;
}