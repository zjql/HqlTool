package com.hql.tool.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangzhijie
 * 2020/4/29 9:18
 */
@Data
@ApiModel(value = "DemoVO",discriminator = "测试返回类")
public class DemoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建人",example = "张晨")
    private String name;
    @ApiModelProperty(value = "创建时间",example = "2020-02-02")
    private String dateTime;
}
