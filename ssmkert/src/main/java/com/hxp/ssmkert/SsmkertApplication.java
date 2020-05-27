package com.hxp.ssmkert;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxp.ssmkert.mapper")
public class SsmkertApplication {

    public static void main(String[] args) {
        System.out.println("Hello,Welcome to SpaceSupermarket");
        SpringApplication.run(SsmkertApplication.class, args);
    }

}
