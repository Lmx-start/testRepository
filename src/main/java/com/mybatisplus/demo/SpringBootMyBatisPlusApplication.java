package com.mybatisplus.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mybatisplus.demo.mapper")
@SpringBootApplication
public class SpringBootMyBatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMyBatisPlusApplication.class, args);
    }

}
