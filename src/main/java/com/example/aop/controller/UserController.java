package com.example.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: 曾睿
 * @Date: 2021/5/11 16:22
 */
@Slf4j
@Component
public class UserController {

    public String getUser() {
        try {
            return "正常";
        } catch (Exception e) {
            log.error("getUser接口错误");
            return "异常";
        }
    }

}
