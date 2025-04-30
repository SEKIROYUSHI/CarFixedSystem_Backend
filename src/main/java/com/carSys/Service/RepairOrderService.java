package com.carSys.Service;

import com.carSys.Entity.RepairOrder;
import com.carSys.Mapper.RepairOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RepairOrderService {
    @Autowired
    private RepairOrderMapper repairOrderMapper;

    // 生成新订单（核心逻辑）
    public long createRepairOrder(RepairOrder order) {
        // 校验车辆和用户是否存在（需注入VehicleService和UserService）
        // vehicleService.getVehicleById(order.getVehicle_id());
        // userService.getUserById(order.getUser_id());

        order.setCreate_time(LocalDateTime.now()); // 设置创建时间
        int result = repairOrderMapper.insertRepairOrder(order);
        return result > 0 ? order.getOrder_id() : 0;
    }

    // 查询订单详情
    public RepairOrder getRepairOrderById(long order_id) {
        return repairOrderMapper.selectRepairOrderById(order_id);
    }

    // 查询用户所有订单
    public List<RepairOrder> getRepairOrdersByUserId(long user_id) {
        return repairOrderMapper.selectRepairOrdersByUserId(user_id);
    }

    public List<RepairOrder> getRepairOrderByVehicleId(long vehicle_id){
        return repairOrderMapper.selectRepairOrderByVehicleId(vehicle_id);
    }

    // 更新订单状态（如标记为完成）
    public int updateOrderStatus(RepairOrder order) {
        return repairOrderMapper.updateRepairOrderStatus(order);
    }
}