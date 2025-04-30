package com.carSys.Mapper;

import com.carSys.Entity.Assignment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssignmentMapper {
    // 插入任务分配
    int insertAssignment(Assignment assignment);

    // 根据订单ID查询分配记录
    List<Assignment> selectAssignmentsByOrderId(long order_id);

    // 根据维修人员ID查询分配记录
    List<Assignment> selectAssignmentsByRepairPersonId(long repair_person_id);
    //todo：此处更新状态可能不需要更新整个对象，而是只需要找到id后更改其状态即可
    //更新分配状态
    int updateAssignmentStatus(Assignment assignment);
}