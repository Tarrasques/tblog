package com.tblog.tlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tblog.tlog.mapper")
public class TlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlogApplication.class, args);
    }

}
