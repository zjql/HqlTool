package com.hql.tool.service.Impl;

import com.hql.tool.dto.DemoMapper;
import com.hql.tool.model.Demo;
import com.hql.tool.service.DemoService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author zhangzhijie
 * 2020/4/24 21:02
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public Demo getTextData(int id) {

        ArrayList<Object> objects = new ArrayList<>();
        return demoMapper.selectByPrimaryKey(id);

    }
}
