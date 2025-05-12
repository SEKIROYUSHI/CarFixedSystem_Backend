package com.carSys.Entity;

import com.carSys.Enums.TaskType;
import lombok.Data;

import java.util.List;

@Data
public class OrderCreationRequest {
    private RepairOrder order;
    private List<TaskType> taskTypes;
}