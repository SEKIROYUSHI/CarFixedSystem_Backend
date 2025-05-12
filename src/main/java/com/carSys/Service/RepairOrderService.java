package com.carSys.Service;

import com.carSys.Entity.Assignment;
import com.carSys.Entity.OrderCreationRequest;
import com.carSys.Entity.RepairOrder;
import com.carSys.Entity.RepairPerson;
import com.carSys.Enums.AssignmentStatus;
import com.carSys.Enums.TaskType;
import com.carSys.Mapper.RepairOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RepairOrderService {
    @Autowired
    private RepairOrderMapper repairOrderMapper;

    @Autowired
    private AssignmentService assignmentService;

    // 生成新订单（核心逻辑）

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

    public long createRepairOrderWithAssignments(OrderCreationRequest request) {
        // 1. 保存订单
        RepairOrder order = request.getOrder();
        order.setCreate_time(LocalDateTime.now());
        repairOrderMapper.insertRepairOrder(order);
        long orderId = order.getOrder_id(); // 获取生成的订单ID

        // 2. 为每个任务类型创建对应的分配任务
        List<TaskType> taskTypes = request.getTaskTypes();
        for (TaskType taskType : taskTypes) {
                // 4. 创建分配任务
                Assignment assignment = new Assignment();
                assignment.setOrder_id(orderId);
                assignment.setStatus(AssignmentStatus.PENDING);
                assignment.setTask_type(taskType);

                // 5. 保存分配任务
                assignmentService.insertAssignment(assignment);
        }
        return orderId;
    }

}