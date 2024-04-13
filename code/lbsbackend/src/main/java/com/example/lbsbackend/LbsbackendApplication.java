package com.example.lbsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.example.lbsbackend.mapper"})
@SpringBootApplication
public class LbsbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LbsbackendApplication.class, args);
    }

}
