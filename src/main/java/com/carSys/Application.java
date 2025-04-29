package com.carSys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.carSys")
//todo:使用较为新的依赖
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}