package com.example.aop.两者结合使用.OperationLogger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
@Aspect
@Component
@Slf4j
public class LoggerAspect {

    /**
     * 开始时间
     */
    Date startTime;

    @Pointcut(value = "@annotation(operationLogger)")
    public void pointcut(OperationLogger operationLogger) {

    }

    @Around(value = "pointcut(operationLogger)")
    public Object doAround(ProceedingJoinPoint joinPoint, OperationLogger operationLogger) throws Throwable {

        startTime = new Date();

        //先执行业务
        Object result = joinPoint.proceed();

        try {
            // 日志收集
//            handle(joinPoint);

        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }


    @AfterThrowing(value = "pointcut(operationLogger)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, OperationLogger operationLogger, Throwable e) throws Exception {

//        ExceptionLog exception = new ExceptionLog();
//        HttpServletRequest request = RequestHolder.getRequest();
//        String ip = IpUtils.getIpAddr(request);
//        exception.setIp(ip);
//        String operationName = AspectUtil.INSTANCE.parseParams(joinPoint.getArgs(), operationLogger.value());
//
//        //从Redis中获取IP来源
//        String jsonResult = redisUtil.get(RedisConf.IP_SOURCE + Constants.SYMBOL_COLON + ip);
//        if (StringUtils.isEmpty(jsonResult)) {
//            String addresses = IpUtils.getAddresses(SysConf.IP + SysConf.EQUAL_TO + ip, SysConf.UTF_8);
//            if (StringUtils.isNotEmpty(addresses)) {
//                exception.setIpSource(addresses);
//                redisUtil.setEx(RedisConf.IP_SOURCE + Constants.SYMBOL_COLON + ip, addresses, 24, TimeUnit.HOURS);
//            }
//        } else {
//            exception.setIpSource(jsonResult);
//        }
//
//        //设置请求信息
//        exception.setIp(ip);
//
//        //设置调用的方法
//        exception.setMethod(joinPoint.getSignature().getName());
//
//        exception.setExceptionJson(JSON.toJSONString(e,
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteMapNullValue));
//        exception.setExceptionMessage(e.getMessage());
//
//        exception.setOperation(operationName);
//        exception.setCreateTime(new Date());
//        exception.setUpdateTime(new Date());
//
//        exception.insert();
    }


//    /**
//     * 管理员日志收集
//     *
//     * @param point
//     * @throws Exception
//     */
//    private void handle(ProceedingJoinPoint point) throws Exception {
//
//        HttpServletRequest request = RequestHolder.getRequest();
//
//        Method currentMethod = AspectUtil.INSTANCE.getMethod(point);
//
//        //获取操作名称 --- 使用注解的方法名称
//        OperationLogger annotation = currentMethod.getAnnotation(OperationLogger.class);
//
//        // 注解内部内部参数 --- 是否保存
//        boolean save = annotation.save();
//
//        String bussinessName = AspectUtil.INSTANCE.parseParams(point.getArgs(), annotation.value());
//
//        String ua = RequestUtil.getUa();
//
//        log.info("{} | {} - {} {} - {}", bussinessName, IpUtils.getIpAddr(request), RequestUtil.getMethod(), RequestUtil.getRequestUrl(), ua);
//        if (!save) {
//            return;
//        }
//
//        // 获取参数名称和值
//        Map<String, Object> nameAndArgsMap = AopUtils.getFieldsName(point);
//
//        String paramsJson = JSONObject.toJSONString(nameAndArgsMap);
//
//        // 异步存储日志
//        sysLogHandle.setSysLogHandle(paramsJson, point.getTarget().getClass().getName(), point.getSignature().getName(), bussinessName, startTime);
//
//        sysLogHandle.onRun();
//    }
}
