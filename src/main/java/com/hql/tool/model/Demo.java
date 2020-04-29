package com.hql.tool.model;

import java.io.Serializable;
import java.util.Date;

public class Demo implements Serializable {
    private Integer id;

    private String founderName;

    private Date founderDate;

    private String updateName;

    private Date updateDate;

    private Integer isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName == null ? null : founderName.trim();
    }

    public Date getFounderDate() {
        return founderDate;
    }

    public void setFounderDate(Date founderDate) {
        this.founderDate = founderDate;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}