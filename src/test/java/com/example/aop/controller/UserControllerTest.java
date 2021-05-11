package com.example.aop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 曾睿
 * @Date: 2021/5/11 16:48
 */
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    void getUser() {
        System.out.println(userController.getUser());
    }
}
