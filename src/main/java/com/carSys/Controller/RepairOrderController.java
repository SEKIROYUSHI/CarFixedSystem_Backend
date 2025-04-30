package com.carSys.Controller;

import com.carSys.Entity.RepairOrder;
import com.carSys.Service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/repairOrder")
public class RepairOrderController {
    @Autowired
    private RepairOrderService repairOrderService;

    // 创建新订单（用户提交维修请求）
    @PostMapping("/createOrder")
    public long createOrder(@RequestBody RepairOrder order) {
        return repairOrderService.createRepairOrder(order);
    }

    // 查询订单详情
    @GetMapping("/{orderId}")
    public RepairOrder getOrderById(@PathVariable long orderId) {
        return repairOrderService.getRepairOrderById(orderId);
    }

    // 查询用户所有订单
    @GetMapping("/getOrdersByUserId/{userId}")
    public List<RepairOrder> getOrdersByUserId(@PathVariable long userId) {
        return repairOrderService.getRepairOrdersByUserId(userId);
    }

    @GetMapping("/getOrdersByUserId/{userId}")
    public List<RepairOrder> getOrdersByVehicleId(@PathVariable long vehicleId) {
        return repairOrderService.getRepairOrderByVehicleId(vehicleId);
    }

    // 更新订单状态（如管理员操作）
    @PutMapping("/updateStatus")
    public int updateOrderStatus(@RequestBody RepairOrder order) {
        return repairOrderService.updateOrderStatus(order);
    }
}