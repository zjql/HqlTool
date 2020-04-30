package com.hql.tool.config.utils;

import lombok.Data;

import java.util.List;

/**
 * @author zhangzhijie
 * 2020/4/30 14:47
 */
@Data
public class ListPageUtil<T> {
    private int pageNo = 1;
    private long totalCount;
    private int pageCount;
    private int pageSize = 10;
    private List<T> data;

    /**
     * 开始分页
     * @param list
     * @param pageNum 页码
     * @param pageSize 每页多少条数据
     * @return
     */
    public static ListPageUtil startPage(List<?> data, Integer pageNum,
                                         Integer pageSize) {
        if (data == null) {
            return null;
        }
        if (data.size() == 0) {
            return null;
        }

        Integer count = data.size(); // 记录总数
        Integer pageCount = 0; // 页数
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }

        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引

        if (pageNum != pageCount) {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }
        if(toIndex>data.size()){
            return null;
        }
        List pageList = data.subList(fromIndex, toIndex);
        ListPageUtil listPageUtil = new ListPageUtil();
        listPageUtil.setPageNo(pageNum);
        listPageUtil.setPageSize(pageSize);
        listPageUtil.setTotalCount(count);
        listPageUtil.setPageCount(pageCount);
        listPageUtil.setData(pageList);
        return listPageUtil;
    }
}
