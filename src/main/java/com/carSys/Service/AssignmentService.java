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

    // 分配维修任务
    public boolean assignRepairTask(Assignment assignment) {
        return assignmentMapper.insertAssignment(assignment) > 0;
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