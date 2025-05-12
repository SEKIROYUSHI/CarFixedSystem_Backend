package com.carSys.Mapper;

import com.carSys.Entity.Assignment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssignmentMapper {
    // 插入任务分配
    int insertAssignment(Assignment assignment);

    int distributeAssignment(@Param("assignment_id") long assignment_id,@Param("repair_person_id") long repairPersonId);

    int refuseAssignment(@Param("assignment_id") long assignment_id,@Param("repair_person_id") long repairPersonId);

    String getRefusedRepairPersonsByAssignmentId(@Param("assignment_id") long assignment_id);

    int acceptAssignment(@Param("assignment_id") long assignment_id,@Param("repair_person_id") long repairPersonId);

    int completeAssignment(@Param("assignment_id") long assignment_id);

    // 根据订单ID查询分配记录
    List<Assignment> selectAssignmentsByOrderId(long order_id);

    // 根据维修人员ID查询分配记录
    List<Assignment> selectAssignmentsByRepairPersonId(long repair_person_id);

    //更新分配状态
    int updateAssignmentStatus(Assignment assignment);

    Assignment getAssignmentById(long assignment_id);
}