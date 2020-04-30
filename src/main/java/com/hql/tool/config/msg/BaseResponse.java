package com.hql.tool.config.msg;


import lombok.Data;

import java.util.Date;

/**
 * http 请求返回最外层对象
 * @author zhangzhijie
 * 2020/4/30 9:28
 */
@Data
public class BaseResponse<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

    /**
     * 时间戳
     */
    private Date responseTime;
}
