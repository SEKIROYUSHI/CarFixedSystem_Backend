package com.carSys.Controller;

import com.carSys.Entity.MaterialUsage;
import com.carSys.Service.MaterialUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/materialUsage")
public class MaterialUsageController {

    @Autowired
    private MaterialUsageService materialUsageService;

    /**
     * 新增单条材料使用记录
     * @param usage 需包含 order_id（订单ID）、part_id（零件ID）、quantity（使用数量）
     */
    @PostMapping("/create")
    public boolean createMaterialUsage(@RequestBody MaterialUsage usage) {
        return materialUsageService.addMaterialUsage(usage);
    }

    /**
     * 批量新增材料使用记录（一个订单使用多个零件）
     * @param usageList 材料使用记录列表
     */
    @PostMapping("/batchCreate")
    public boolean batchCreateMaterialUsage(@RequestBody List<MaterialUsage> usageList) {
        return materialUsageService.batchAddMaterialUsage(usageList);
    }

    /**
     * 根据订单 ID 查询材料使用记录
     * @param orderId 维修订单 ID
     */
    @GetMapping("/byOrder/{orderId}")
    public List<MaterialUsage> getUsageByOrderId(@PathVariable long orderId) {
        return materialUsageService.getUsageByOrderId(orderId);
    }

    /**
     * 根据零件 ID 查询关联的订单 ID（反向查询）
     * @param partId 零件 ID
     */
    @GetMapping("/byPart/{partId}")
    public List<Long> getOrderIdsByPartId(@PathVariable long partId) {
        return materialUsageService.getOrderIdsByPartId(partId);
    }

    /**
     * 根据订单 ID 删除所有材料使用记录
     * @param orderId 维修订单 ID
     */
    @DeleteMapping("/deleteByOrder/{orderId}")
    public boolean deleteUsageByOrderId(@PathVariable long orderId) {
        return materialUsageService.deleteUsageByOrderId(orderId);
    }
}