package com.hql.tool.service.Impl;

import com.hql.tool.dto.DemoDto;
import com.hql.tool.mapper.DemoMapper;
import com.hql.tool.model.Demo;
import com.hql.tool.service.DemoService;
import com.hql.tool.vo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DemoVO getTextData(DemoDto dto) {
        return demoMapper.getCreateDateTime(dto);

    }
}
