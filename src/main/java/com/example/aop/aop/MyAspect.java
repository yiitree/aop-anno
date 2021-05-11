package com.example.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Slf4j
@Aspect
@Component
public class MyAspect {

    // 切点作用位置
    @Pointcut("execution(* com.example.aop.controller.*.*(..))")
    public void pointcut() {
    }

    // 调用方法前
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {

        System.out.println("前置通知");

        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
    }

    // 调用方法后
    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("后置通知");
    }

    // 在切入点方法执行并有返回值才执行该方法
    @AfterReturning("pointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("doAfterReturning");
    }

    // 在切入点方法抛出异常的时候执行该方法
    @AfterThrowing("pointcut()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        System.out.println("doAfterThrowing");
    }

    // 最灵活的方法 - 和代理一样，自定义方法执行时间
    // 环绕通知 --- 在执行切入点方法的前后执行该方法
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 记录接口执行前的时间戳
        long startTime = System.currentTimeMillis();

        // 执行原目标方法
        Object result = proceedingJoinPoint.proceed();

        // 计算接口耗时
        log.info("------------ 耗时: {} ms ------------", System.currentTimeMillis() - startTime);
        // 只做增强不做改变，还是要把接口原本的结果返回
        return result;
    }

}

