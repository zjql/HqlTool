package com.hql.tool.config.msg;

import com.hql.tool.config.constant.SysConstant;

import java.util.Date;

/**
 * 请求返回最外层处理工具类
 * @author zhangzhijie
 * 2020/4/30 9:59
 */
public class ResponseMsgUtil {

    /**
     * 处理成功响应方法-有结果集
     * @param object 结果集对象
     * @return BaseResponse 包装后的统一结果实体
     */
     public static BaseResponse success(Object object){
         BaseResponse baseResponse = new BaseResponse();
         baseResponse.setCode(SysConstant.SYS_CODE_SUCCESS);
         baseResponse.setMsg(SysConstant.SYS_MSG_SUCCESS);
         baseResponse.setData(object);
         baseResponse.setResponseTime(new Date());
         return baseResponse;
     }

    /**
     * 处理成功响应方法-有结果集 自定义响应码
     * @param code
     * @param object
     * @return BaseResponse 包装后的统一结果实体
     */
     public static BaseResponse success(Integer code,Object object){
         BaseResponse baseResponse = new BaseResponse();
         baseResponse.setCode(code);
         baseResponse.setMsg(SysConstant.SYS_MSG_SUCCESS);
         baseResponse.setData(object);
         baseResponse.setResponseTime(new Date());
         return baseResponse;
     }

    /**
     * 处理成功响应方法 - 无结果集的
     * @return BaseResponse 包装后的统一结果实体
     */
    public static BaseResponse success(){
         return success(null);
     }

    /**
     * 处理失败响应方法
     * @param msg
     * @return BaseResponse 包装后的统一结果实体
     */
     public static BaseResponse error(String msg){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(SysConstant.SYS_CODE_ERROR);
        baseResponse.setMsg(msg);
        baseResponse.setResponseTime(new Date());
        return baseResponse;
     }

    /**
     * 处理警告响应方法
     *
     * @param code
     * @param msg 错误信息
     * @return BaseResponse 包装后的统一结果实体
     */
    public static BaseResponse warn(int code, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setResponseTime(new Date());
        baseResponse.setMsg(msg);
        return baseResponse;
    }

    /**
     * 处理失败响应方法
     *
     * @param msg 错误信息
     * @return BaseResponse 包装后的统一结果实体
     */
    public static BaseResponse error(Integer code, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setResponseTime(new Date());
        baseResponse.setMsg(msg);
        return baseResponse;
    }
}
