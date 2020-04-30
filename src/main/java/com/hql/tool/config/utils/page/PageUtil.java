package com.hql.tool.config.utils.page;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.Page;
import com.hql.tool.config.exception.BusinessException;
import com.hql.tool.config.utils.ConverterUtil;
import com.hql.tool.dto.QueryParamsBaseDto;

import java.util.List;

/**
 * @author zhangzhijie
 * 2020/4/30 10:50
 */
public class PageUtil {

    /**
     * 提取QueryParamsBaseDto pageNum
     * @param page 统一请求参数类
     * @return
     */
    public static int getPageNum(QueryParamsBaseDto page){
        if (ObjectUtil.isNotNull(page)) {
            return page.getPageNum() == 0 ? 1 : page.getPageNum();
        }else {
            throw new BusinessException("参数为空");
        }
    }

    /**
     * 提取QueryParamBaseDto里的PageSize
     * @param param 报表统一请求参数类
     * @return
     */
    public static int getPageSize(QueryParamsBaseDto param) {
        if (ObjectUtil.isNotNull(param)) {
            return param.getPageSize() == 0 ? 10 : param.getPageSize();
        } else {
            throw new BusinessException("参数为空");
        }
    }

    /**
     * 转换为分页对象
     * @param clazz 统一请求参数类
     * @param params SQL查询结果集合
     * @param <T>
     * @return
     */
    public static <T> PageInfos<T> convertPageObj(Class<T> clazz, List<T> params){
        Page<T> page = (Page<T>) (params);
        List<T> list = ConverterUtil.convert(params, clazz);
        PageInfos<T> pageInfos = PageInfos.pageChange(list, page);
        return pageInfos;
    }
}
