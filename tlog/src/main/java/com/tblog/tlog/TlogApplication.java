package com.tblog.tlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan("com.tblog.tlog.mapper")
@EnableWebSecurity
@EnableEurekaClient
public class TlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlogApplication.class, args);
    }

}
