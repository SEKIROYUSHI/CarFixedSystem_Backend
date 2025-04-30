package com.carSys.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    private long part_id;       // 零件 ID（主键）
    private String part_name;   // 零件名称（如 "刹车片", "机油滤芯"）
    private double unit_price;  // 单价（元）
    private String category;    // 分类（如 "易损件", "电子元件"）
}