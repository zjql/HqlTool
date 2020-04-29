package com.hql.tool.mapper;

import com.hql.tool.dto.DemoDto;
import com.hql.tool.model.Demo;
import com.hql.tool.vo.DemoVO;

public interface DemoMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);

    DemoVO getCreateDateTime(DemoDto demoDto);
}