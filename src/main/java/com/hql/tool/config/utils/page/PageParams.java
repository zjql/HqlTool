package com.hql.tool.config.utils.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author zhangzhijie
 * 2020/4/30 10:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParams implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认页码下标
     */
    public static final int DEFAULT_INDEX = 1;

    /**
     * 默认每页尺寸
     */
    public static final int DEFAULT_SIZE = 10;

    // 页码下标，从0开始，用于区分页面对象page，不重名
    @Min(value = 0)
    private int index = DEFAULT_INDEX;

    // 每页尺寸，大于0
    @Min(value = 1)
    private int size = DEFAULT_SIZE;

    /**
     * 获取分页偏移量
     * @return 分页偏移量
     */
    public int getOffset() {
        return (index - 1) * size;
    }
}
