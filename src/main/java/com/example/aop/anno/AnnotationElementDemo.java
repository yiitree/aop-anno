package com.example.aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解嵌套
 */
public @interface AnnotationElementDemo {

    /**
     * 注解里面使用注解
     */
    Reference reference() default @Reference(next=true);

    //枚举类型
    enum Status {FIXED,NORMAL};

    //声明枚举
    Status status() default Status.FIXED;

    //布尔类型
    boolean showSupport() default false;

    //String类型
    String name()default "";

    //class类型
    Class<?> testCase() default Void.class;

    //数组类型
    long[] value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Reference{
    boolean next() default false;
}
