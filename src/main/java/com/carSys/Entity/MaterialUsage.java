package com.carSys.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUsage {
    private long order_id;  // 维修订单 ID（外键，关联 repair_order.order_id）
    private long part_id;   // 零件 ID（外键，关联 part.part_id）
    private int quantity;   // 本次维修使用的零件数量
}