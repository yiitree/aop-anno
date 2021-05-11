package com.example.aop;

import com.example.aop.aop.EnableApiTimeLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 自定义注解  --- 本质调用spring提供的import注解，把bean交给spring
@EnableApiTimeLog
@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

}
