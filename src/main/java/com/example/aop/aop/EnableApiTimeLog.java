package com.example.aop.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启接口耗时计算
 */
// spring提供的注解信息 --- 把对应的class实例化并加载到容器
//@Import({ApiTimeLogAspect.class,ApiLogAspect.class,MyAspect.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableApiTimeLog {
}
