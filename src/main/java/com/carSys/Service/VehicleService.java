package com.carSys.Service;

import com.carSys.Entity.Vehicle;
import com.carSys.Mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService{

    @Autowired
    private VehicleMapper vehicleMapper;

    public Vehicle getVehicleById(long vehicle_id) {
        return vehicleMapper.selectVehicleById(vehicle_id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleMapper.selectAllVehicles();
    }


    public int addVehicle(Vehicle vehicle) {
        return vehicleMapper.insertVehicle(vehicle);
    }

    public int updateVehicle(Vehicle vehicle) {
        return vehicleMapper.updateVehicle(vehicle);
    }

    public int deleteVehicle(long vehicle_id) {
        return vehicleMapper.deleteVehicle(vehicle_id);
    }

    public List<Vehicle> getVehiclesByUserId(long user_id) {
        return vehicleMapper.selectVehiclesByUserId(user_id);
    }
}