package com.dynamic.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class DynamicBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicBaseApplication.class, args);
    }
}
