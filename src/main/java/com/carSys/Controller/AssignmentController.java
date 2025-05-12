package com.carSys.Controller;

import com.carSys.Entity.Assignment;
import com.carSys.Service.AssignmentService;
import com.carSys.Service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private RepairOrderService repairOrderService;

    // 分配维修任务（例如：管理员指派维修人员到订单）
    @PostMapping("/insertAssignment")
    public boolean insertRepairTask(@RequestBody Assignment assignment) {
        return assignmentService.insertAssignment(assignment);
    }

    @PostMapping("/distributeAssignment/{repairPersonId}/{assignment_id}")
    public boolean distributeAssignment(@PathVariable long repairPersonId,@PathVariable long assignment_id) {
        return assignmentService.distributeAssignment(assignment_id,repairPersonId);
    }

    // 拒绝维修任务（例如：维修人员拒绝接单）
    @PostMapping("/refuseAssignment/{repairPersonId}/{assignment_id}")
    public boolean refuseAssignment(@PathVariable long repairPersonId,@PathVariable long assignment_id) {
        boolean result1 =  assignmentService.refuseAssignment(assignment_id,repairPersonId);
        boolean result2 = repairOrderService.assignRepairPersonToOrder(assignment_id);
        return result1&&result2;
    }

    //todo:此处应该记录接受接单的时间，以结算完成时长
    // 接受维修任务（例如：维修人员接受接单）
    @PostMapping("/acceptAssignment/{repairPersonId}/{assignment_id}")
    public boolean acceptAssignment(@PathVariable long repairPersonId,@PathVariable long assignment_id) {
        return assignmentService.acceptAssignment(assignment_id,repairPersonId);
    }

    // 完成维修任务（例如：维修人员完成维修）
    @PostMapping("/completeAssignment/{assignment_id}")
    public boolean completeAssignment(@PathVariable long assignment_id) {
        return assignmentService.completeAssignment(assignment_id);
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