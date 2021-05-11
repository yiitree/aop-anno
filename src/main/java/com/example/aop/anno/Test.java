package com.example.aop.anno;

import java.lang.annotation.*;

/**
 * 声明一个注解
 *
 * 元注解：java提供的最基本的注解，用于描述自定义注解信息：注解使用位置，使用时间
 * 请注意，当注解未指定Target值时，则此注解可以用于任何元素之上，多个值使用{}包含并用逗号隔开
 *
 */



// 使用位置：只能用于方法上
//@Target(ElementType.METHOD)
@Target(value={ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE})

// 使用时间：注解生存期是运行时
@Retention(RetentionPolicy.RUNTIME)

//@Documented 被修饰的注解会生成到javadoc中
@Documented

//@Inherited 可以让注解被继承，但这并不是真的继承，
// 只是通过使用@Inherited，可以让子类Class对象使用getAnnotations()获取父类被@Inherited修饰的注解
@Inherited
public @interface Test {

}
