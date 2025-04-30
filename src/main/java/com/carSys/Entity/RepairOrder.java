package com.carSys.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairOrder {
    private long order_id;          // 订单ID
    private long vehicle_id;        // 车辆ID（外键）
    private long user_id;           // 用户ID（外键）
    private String assigned_status; // 分配状态（如"待分配"、"已分配"）
    private LocalDateTime create_time; // 创建时间
    private LocalDateTime complete_time; // 完成时间
    private double total_cost;      // 总费用
    private String status;          // 订单状态（如"进行中"、"已完成"）
}