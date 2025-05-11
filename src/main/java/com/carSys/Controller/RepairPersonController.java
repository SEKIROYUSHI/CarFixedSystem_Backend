package com.carSys.Controller;

import com.carSys.Entity.RepairPerson;
import com.carSys.Enums.TaskType;
import com.carSys.Service.RepairPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/repairPerson")
public class RepairPersonController {
    @Autowired
    private RepairPersonService repairPersonService;

    // 创建维修人员
    @PostMapping("/create")
    public boolean createRepairPerson(@RequestBody RepairPerson repairPerson) {
        return repairPersonService.createRepairPerson(repairPerson);
    }

    // 根据ID查询维修人员
    @GetMapping("/{repairPersonId}")
    public RepairPerson getRepairPersonById(@PathVariable long repairPersonId) {
        return repairPersonService.getRepairPersonById(repairPersonId);
    }

    // 根据用户ID查询维修人员
    @GetMapping("/user/{userId}")
    public RepairPerson getRepairPersonByUserId(@PathVariable long userId) {
        return repairPersonService.getRepairPersonByUserId(userId);
    }

    // 更新维修人员信息
    @PutMapping("/update")
    public boolean updateRepairPerson(@RequestBody RepairPerson repairPerson) {
        return repairPersonService.updateRepairPerson(repairPerson);
    }

    // 删除维修人员
    @DeleteMapping("/{repairPersonId}")
    public boolean deleteRepairPerson(@PathVariable long repairPersonId) {
        return repairPersonService.deleteRepairPerson(repairPersonId);
    }

    // 根据专业查询维修人员
    @GetMapping("/specialty/{specialty}")
    public List<RepairPerson> getRepairPersonBySpecialty(@PathVariable TaskType specialty) {
        return repairPersonService.getRepairPersonBySpecialty(specialty);
    }
}