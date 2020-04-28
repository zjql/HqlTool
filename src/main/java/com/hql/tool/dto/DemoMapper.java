package com.hql.tool.dto;

import com.hql.tool.model.Demo;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}