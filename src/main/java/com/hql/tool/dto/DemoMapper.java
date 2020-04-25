package com.hql.tool.dto;

import com.hql.tool.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperation;

/**
 * @author zhangzhijie
 * 2020/4/24 20:57
 */
@Mapper
public interface DemoMapper{

    Demo queryTextDemo();
}
