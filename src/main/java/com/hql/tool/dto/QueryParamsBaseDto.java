package com.hql.tool.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangzhijie
 * 2020/4/30 11:06
 */
@Data
@ApiModel(value = "QueryParamsBaseDto",discriminator = "入参类")
public class QueryParamsBaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "页码",example = "1")
    private int pageNum;
    @ApiModelProperty(value = "每页条数",example = "10")
    private int pageSize;
}
