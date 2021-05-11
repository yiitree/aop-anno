package com.example.aop.两者结合使用.OperationLogger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 日志切面
 *
 * @author 陌溪
 * @date 2020年12月31日21:26:04
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect {

    /**
     * 开始时间
     */
    Date startTime;

    /**
     * aop使用的位置 --- 被operationLogger注解所用的方法
     * @param operationLogger
     */
    @Pointcut("@annotation(operationLogger)")
    public void pointcut(OperationLogger operationLogger) {}


    @Around(value = "pointcut(operationLogger)")
    public Object doAround(ProceedingJoinPoint joinPoint, OperationLogger operationLogger) throws Throwable {
        startTime = new Date();
        //先执行业务
        System.out.println(operationLogger.value());
        Object result = joinPoint.proceed();
        System.out.println("方法执行完毕：开始执行时间："+startTime);
        return result;
    }
}
