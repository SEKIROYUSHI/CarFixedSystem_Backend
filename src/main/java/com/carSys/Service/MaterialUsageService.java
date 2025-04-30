package com.carSys.Service;

import com.carSys.Entity.MaterialUsage;
import com.carSys.Mapper.MaterialUsageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MaterialUsageService {

    @Autowired
    private MaterialUsageMapper materialUsageMapper;

    /**
     * 插入单条材料使用记录（维修时关联订单与零件）
     */
    public boolean addMaterialUsage(MaterialUsage usage) {
        return materialUsageMapper.insertMaterialUsage(usage) > 0;
    }

    /**
     * 批量插入材料使用记录（适用于订单使用多个零件）
     */
    public boolean batchAddMaterialUsage(List<MaterialUsage> usageList) {
        if (CollectionUtils.isEmpty(usageList)) {
            return false;
        }
        return materialUsageMapper.batchInsertMaterialUsage(usageList) > 0;
    }

    /**
     * 根据订单 ID 查询该订单使用的所有材料记录
     */
    public List<MaterialUsage> getUsageByOrderId(long orderId) {
        return materialUsageMapper.selectUsageByOrderId(orderId);
    }

    /**
     * 根据零件 ID 查询使用该零件的所有订单 ID（反向关联）
     */
    public List<Long> getOrderIdsByPartId(long partId) {
        return materialUsageMapper.selectOrderIdsByPartId(partId);
    }

    /**
     * 根据订单 ID 删除所有关联的材料使用记录（如订单取消时清理）
     */
    public boolean deleteUsageByOrderId(long orderId) {
        return materialUsageMapper.deleteUsageByOrderId(orderId) > 0;
    }
}