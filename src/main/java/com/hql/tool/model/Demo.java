package com.hql.tool.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * demo
 * @author 
 */
@Data
public class Demo implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 创建人
     */
    private String founderName;

    /**
     * 创建时间
     */
    private Date founderDate;

    /**
     * 更新人
     */
    private String updateName;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 是否删除(0未删除1已删除)
     */
    private Integer isDelete;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}