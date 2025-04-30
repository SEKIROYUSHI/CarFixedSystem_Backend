package com.carSys.Mapper;

import com.carSys.Entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleMapper {
    //todo：此处我不清楚根据车辆生成order的操作是否需要后端提供接口，或者可以直接前端实现，获取id后生成订单信息直接使用订单相关接口即可。
    //根据车辆 ID 查询车辆
    Vehicle selectVehicleById(long vehicle_id);
    // 查询所有车辆
    List<Vehicle> selectAllVehicles();
    // 插入新车辆
    int insertVehicle(Vehicle vehicle);
    // 根据车辆 ID 更新车辆信息
    int updateVehicle(Vehicle vehicle);
    // 根据车辆 ID 删除车辆
    int deleteVehicle(long vehicle_id);

    List<Vehicle> selectVehiclesByUserId(long user_id);
}