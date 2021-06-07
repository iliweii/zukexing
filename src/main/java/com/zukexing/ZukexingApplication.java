package com.zukexing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zukexing.dao")
@SpringBootApplication
public class ZukexingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZukexingApplication.class, args);
    }

}
