package com.example.lcsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LcsbackendApplication
 *
 * @description: main entrance class
 */
@MapperScan(basePackages = {"com.example.lcsbackend.mapper"})
@SpringBootApplication
public class LcsbackendApplication {

    /**
     * main
     *
     * @description: main entrance function
     * @param: String[] args
     * @return: void
     */
    public static void main(String[] args) {
        SpringApplication.run(LcsbackendApplication.class, args);
    }

}
