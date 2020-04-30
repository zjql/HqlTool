package com.hql.tool.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.naming.Name;
import java.io.Serializable;

/**
 * @author zhangzhijie
 * 2020/4/29 9:14
 */
@Data
@ApiModel(value = "DemoDto",discriminator = "测试入参")
public class DemoDto extends QueryParamsBaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建人",example = "张晨")
    private String name;

}
