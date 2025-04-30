package com.carSys.Controller;

import com.carSys.Entity.Assignment;
import com.carSys.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // 分配维修任务（例如：管理员指派维修人员到订单）
    @PostMapping("/assignTask")
    public boolean assignRepairTask(@RequestBody Assignment assignment) {
        return assignmentService.assignRepairTask(assignment);
    }

    // 根据订单 ID 查询分配记录（可能一个订单对应多个分配，如不同维修人员）
    @GetMapping("/byOrderId/{orderId}")
    public List<Assignment> getAssignmentsByOrderId(@PathVariable long orderId) {
        return assignmentService.getAssignmentsByOrderId(orderId);
    }

    // 更新分配状态（例如：标记任务为“已完成”）
    @PutMapping("/updateStatus")
    public int updateAssignmentStatus(@RequestBody Assignment assignment) {
        // 假设 AssignmentService 新增了更新方法（需补充到 Service 层）
        return assignmentService.updateAssignmentStatus(assignment);
    }

    // 根据维修人员 ID 查询分配记录
    @GetMapping("/byRepairPersonId/{repairPersonId}")
    public List<Assignment> getAssignmentsByRepairPersonId(@PathVariable long repairPersonId) {
        return assignmentService.getAssignmentsByRepairPersonId(repairPersonId);
    }
}