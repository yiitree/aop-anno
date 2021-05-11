package com.example.aop.两者结合使用.OperationLogger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义日志记录注解
 */
@Target(ElementType.METHOD) // 作用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLogger {

    /**
     * 业务名称
     */
    String value() default "";

}
