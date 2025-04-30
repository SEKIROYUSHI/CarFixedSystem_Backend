package com.carSys.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private long vehicle_id;
    private long user_id;
    private String license_plate;
    private String model;
    private int manufacture_year;
}