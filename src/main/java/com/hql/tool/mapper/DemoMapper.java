package com.hql.tool.mapper;

import com.hql.tool.dto.DemoDto;
import com.hql.tool.model.Demo;
import com.hql.tool.model.DemoExample;
import com.hql.tool.vo.DemoVO;

import java.util.List;

public interface DemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    int insertSelective(Demo record);

    List<Demo> selectByExample(DemoExample example);

    Demo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);

    List<DemoVO> getCreateDateTime(DemoDto demodto);
}