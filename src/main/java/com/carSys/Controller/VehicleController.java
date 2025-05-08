package com.carSys.Controller;

import com.carSys.Entity.Vehicle;
import com.carSys.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // 根据车辆 ID 查询车辆
    @GetMapping("/{vehicle_id}")
    public Vehicle getVehicleById(@PathVariable long vehicle_id) {
        return vehicleService.getVehicleById(vehicle_id);
    }

    // 查询所有车辆
    @GetMapping("/getAllVehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // 插入新车辆
    @PostMapping("/addNewVehicle")
    public int addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    // 根据车辆 ID 更新车辆信息
    @PutMapping("/updateVehicle")
    public int updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    // 根据车辆 ID 删除车辆
    @DeleteMapping("/deleteVehicle/{vehicle_id}")
    public int deleteVehicle(@PathVariable long vehicle_id) {
        return vehicleService.deleteVehicle(vehicle_id);
    }

    @GetMapping("/byUserId/{user_id}")
    public List<Vehicle> getVehiclesByUserId(@PathVariable long user_id) {
        return vehicleService.getVehiclesByUserId(user_id);
    }
}