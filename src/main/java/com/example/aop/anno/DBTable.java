package com.example.aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对应数据表注解
 */
//只能应用于类上
@Target(ElementType.TYPE)
//保存到运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    /**
     * 提供一个参数，参数类型只能为基本类数据类型，不能为包装类
     * default设置默认值
     */
    String name() default "";

}
