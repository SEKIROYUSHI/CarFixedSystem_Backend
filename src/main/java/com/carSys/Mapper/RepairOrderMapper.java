package com.carSys.Mapper;

import com.carSys.Entity.RepairOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairOrderMapper {
    // 插入新订单
    int insertRepairOrder(RepairOrder repairOrder);

    // 根据订单ID查询订单
    RepairOrder selectRepairOrderById(long order_id);

    // 查询用户所有订单
    List<RepairOrder> selectRepairOrdersByUserId(long user_id);

    List<RepairOrder> selectRepairOrderByVehicleId(long vehicle_id);

    // 更新订单状态
    int updateRepairOrderStatus(RepairOrder repairOrder);

    // 删除订单（逻辑删除或物理删除）
    int deleteRepairOrder(long order_id);
}