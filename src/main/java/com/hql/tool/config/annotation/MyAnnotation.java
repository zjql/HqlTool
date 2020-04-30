package com.hql.tool.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: tool
 * @description: 练习注解
 * @author: Zj
 * @create: 2020-06-10 14:52
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    /**
     * 值
     * @return
     */
    String value() default "";
}
