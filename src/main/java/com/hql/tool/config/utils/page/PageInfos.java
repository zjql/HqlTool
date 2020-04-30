package com.hql.tool.config.utils.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息
 * @author zhangzhijie
 * 2020/4/30 10:31
 */
@Data
public class PageInfos<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private int pageNo = 1;

    /**
     * 每页条数
     */
    private int pageSize = 10;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 总条数
     */
    private long totalCount;

    /**
     * 数据
     */
    private List<T> data;

    public PageInfos() {
    }

    public PageInfos(List<T> data) {
        this.data = data;
    }

    /**
     * 计算一共多少页
     */
    public void setTotalPage() {
        if(this.totalCount==0){
            this.pageCount = 0;
        }else{
            this.pageCount = (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)
                    : this.totalCount / this.pageSize);
        }
    }

    /**
     * 分页信息转换
     * @param data
     * @param page
     * @return
     */
    public static PageInfos pageChange(List<?> data, Page page) {
        if (data == null) {
            return null;
        }
        PageInfos pageInfos = new PageInfos();
        try {
            pageInfos.setPageNo(page.getPageNum());
            pageInfos.setPageSize(page.getPageSize());
            pageInfos.setTotalCount(page.getTotal());
            pageInfos.setPageCount(page.getPages());
            pageInfos.setData(data);
        } catch (Exception e) {
        }
        return pageInfos;
    }

    /**
     * 分页信息转换
     * @param data
     * @param page
     * @return
     */
    public static PageInfos pageChange(PageInfo<?> data, Page page) {
        if (data == null) {
            return null;
        }
        PageInfos pageInfos = new PageInfos();
        try {
            pageInfos.setPageNo(page.getPageNum());
            pageInfos.setPageSize(page.getPageSize());
            pageInfos.setTotalCount(page.getTotal());
            pageInfos.setPageCount(page.getPages());
            pageInfos.setData(data.getList());
        } catch (Exception e) {
        }
        return pageInfos;
    }
}
