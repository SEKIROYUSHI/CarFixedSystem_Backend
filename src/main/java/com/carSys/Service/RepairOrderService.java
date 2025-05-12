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
import java.util.Arrays;
import java.util.List;

@Service
public class RepairOrderService {
    @Autowired
    private RepairOrderMapper repairOrderMapper;

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private RepairPersonService repairPersonService;

    // 生成新订单（核心逻辑）

    // 查询订单详情
    public RepairOrder getRepairOrderById(long order_id) {
        return repairOrderMapper.selectRepairOrderById(order_id);
    }

    // 查询用户所有订单
    public List<RepairOrder> getRepairOrdersByUserId(long user_id) {
        return repairOrderMapper.selectRepairOrdersByUserId(user_id);
    }

    public List<RepairOrder> getRepairOrderByVehicleId(long vehicle_id) {
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
            assignRepairPersonToOrder(assignment.getAssignment_id());
        }
        return orderId;
    }

    public boolean assignRepairPersonToOrder(long assignmentId) {
        // 1. 查询订单
        Assignment assignment = assignmentService.getAssignmentById(assignmentId);
        TaskType taskType = assignment.getTask_type();
        List<RepairPerson> fittedRepairPersons = repairPersonService.getRepairPersonBySpecialty(taskType);
        for(RepairPerson repairPerson : fittedRepairPersons) {
            // 2. 分配维修人员
            if(!Arrays.asList(assignment.getRefused_repair_person().split(",")).contains(Long.toString(repairPerson.getRepair_person_id()))) {
               return assignmentService.distributeAssignment(assignmentId, repairPerson.getRepair_person_id());
            }
        }
        return false;
    }
}