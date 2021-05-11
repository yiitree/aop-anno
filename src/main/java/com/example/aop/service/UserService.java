package com.example.aop.service;

import com.example.aop.两者结合使用.OperationLogger.OperationLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 曾睿
 * @Date: 2021/5/11 21:36
 */
@Slf4j
@Service
public class UserService {

    @OperationLogger("sss方法")
    public String sss() {
        try {
            return "正常";
        } catch (Exception e) {
            log.error("getUser接口错误");
            return "异常";
        }
    }

}
