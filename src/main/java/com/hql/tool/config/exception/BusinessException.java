package com.hql.tool.config.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义业务异常类
 * @author zhangzhijie
 * 2020/4/30 11:01
 */
@Data
public class BusinessException extends RuntimeException implements Serializable {

    /**
     * 异常code
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String msg;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
