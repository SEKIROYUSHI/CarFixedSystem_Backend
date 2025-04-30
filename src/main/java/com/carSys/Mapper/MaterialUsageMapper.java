package com.carSys.Mapper;

import com.carSys.Entity.MaterialUsage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaterialUsageMapper {
    /**
     * 插入一条材料使用记录（维修时关联订单与零件）
     */
    int insertMaterialUsage(MaterialUsage usage);

    /**
     * 根据订单 ID 查询该订单使用的所有材料记录
     * @return 包含 part_id 和 quantity 的列表
     */
    List<MaterialUsage> selectUsageByOrderId(long order_id);

    /**
     * 根据零件 ID 查询哪些订单使用了该零件（反向关联）
     */
    List<Long> selectOrderIdsByPartId(long part_id);

    /**
     * 批量插入材料使用记录（用于维修单一次使用多个零件）
     * @param usageList 材料使用记录列表
     */
    int batchInsertMaterialUsage(@Param("list") List<MaterialUsage> usageList);

    /**
     * 根据订单 ID 删除所有关联的材料使用记录（如订单取消时清理）
     */
    int deleteUsageByOrderId(long order_id);
}