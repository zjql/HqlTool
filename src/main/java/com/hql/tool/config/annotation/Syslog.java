package com.hql.tool.config.annotation;

import ch.qos.logback.core.net.SyslogConstants;
import com.hql.tool.config.constant.Constant;

import java.lang.annotation.*;

/**
 * 自定义系统日志记录注解
 *
 * @author zhangzhijie
 * 2020/4/29 10:38
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Syslog {

    /**
     * 描述
     *
     * @return
     */
    String description() default "";

    String level() default Constant.LOGGER_LEVEL_INFO;


}
