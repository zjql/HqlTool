package com.hql.tool.config.aspect;

import com.google.gson.Gson;
import com.hql.tool.config.annotation.Syslog;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.manager.util.SessionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义AOP+注解方式记录controller层日志
 *
 * @author zhangzhijie
 * 2020/4/29 10:47
 */
@Slf4j
@Aspect
@Component
public class SyslogAspect {
    private final Gson gson = new Gson();
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.hql.tool.config.annotation.Syslog)")
    private void controllerAspect() {
    }

    /**
     * 请求method前打印内容
     * @param joinPoint
     */
    @Before(value ="controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        Signature signature =joinPoint.getSignature();
        MethodSignature methodSignature =(MethodSignature) signature;
        Method method = methodSignature.getMethod();
        String description =method.getAnnotation(Syslog.class).description();
        log.info("===============Controller层请求内容===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + signature);
        log.info("请求类方法描述:" + description);
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("===============Controller层请求内容===============");
    }

    /**
     * 在方法执行完后打印返回内容
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "controllerAspect()")
    public void afterReturning(Object object){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("===============Controller层响应内容===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("响应内容:" + gson.toJson(object));
        log.info("请求处理时间为:" + (System.currentTimeMillis() - startTime.get()));
        log.info("===============Controller层响应内容===============");

    }
}
