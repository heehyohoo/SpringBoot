package com.example.formtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value={"com.example.formtest.mapper"})
@SpringBootApplication

public class FormtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormtestApplication.class, args);
    }

}
