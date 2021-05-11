package com.example.aop.controller;

import com.example.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: 曾睿
 * @Date: 2021/5/11 16:48
 */
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;
    @Autowired
    UserService service;

    @Test
    void getUser() {
        System.out.println(userController.getUser());
    }

    @Test
    void getUser2() {
        System.out.println(service.sss());
    }
}
