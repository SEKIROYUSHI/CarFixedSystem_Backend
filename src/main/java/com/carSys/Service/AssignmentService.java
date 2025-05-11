package com.carSys.Service;

import com.carSys.Entity.Assignment;
import com.carSys.Mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentMapper assignmentMapper;

    // 生成维修任务
    public boolean insertAssignment(Assignment assignment) {
        return assignmentMapper.insertAssignment(assignment) > 0;
    }

    // 分配维修任务
    public boolean distributeAssignment(long assignment_id,long repairPersonId) {
        return assignmentMapper.distributeAssignment(assignment_id,repairPersonId) > 0;
    }

    // 拒绝维修任务
    public boolean refuseAssignment(long assignment_id,long repairPersonId) {
        return assignmentMapper.refuseAssignment(assignment_id,repairPersonId) > 0;
    }

    // 接受维修任务
    public boolean acceptAssignment(long assignment_id,long repairPersonId) {
        return assignmentMapper.acceptAssignment(assignment_id,repairPersonId) > 0;
    }

    //完成维修任务
    public boolean completeAssignment(long assignment_id) {
        return assignmentMapper.completeAssignment(assignment_id) > 0;
    }

    // 查询订单对应的分配记录
    public List<Assignment> getAssignmentsByOrderId(long order_id) {
        return assignmentMapper.selectAssignmentsByOrderId(order_id);
    }

    // 查询维修人员对应的分配记录
    public List<Assignment> getAssignmentsByRepairPersonId(long repair_person_id) {
        return assignmentMapper.selectAssignmentsByRepairPersonId(repair_person_id);
    }

    // 更新分配状态
    public int updateAssignmentStatus(Assignment assignment) {
        return assignmentMapper.updateAssignmentStatus(assignment);
    }
}