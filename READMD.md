## aop 和 anno

aop其实就是动态代理/
anno就是通过反射获得原方法

一般来说两者可以结合使用，
aop中主要有两个注解：
1. @Pointcut() : 要增强的方法
2. @Around() : 如何增强

### 最原始的：

使用表达式，全部控制那些是需要增加的方法：\
@Pointcut("execution(* com.example.aop.controller.*.*(..))")

### 进阶：

结合注解使用：\
@Pointcut(value = "@annotation(operationLogger)")
不进行统一控制，而是使用注解，这样就可以手动控制，需要增加的手动添加注解即可
