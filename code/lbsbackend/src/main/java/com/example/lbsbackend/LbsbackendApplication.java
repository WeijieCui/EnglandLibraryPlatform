package com.example.lbsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LbsbackendApplication
 *
 * @description: mian entrance class
 */
@MapperScan(basePackages = {"com.example.lbsbackend.mapper"})
@SpringBootApplication
public class LbsbackendApplication {

    /**
     * main
     *
     * @description: main entrance function
     * @param: String[] args
     * @return: void
     */
    public static void main(String[] args) {
        SpringApplication.run(LbsbackendApplication.class, args);
    }

}
