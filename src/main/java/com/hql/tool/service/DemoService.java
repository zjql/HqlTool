package com.hql.tool.service;


import com.hql.tool.dto.DemoDto;
import com.hql.tool.vo.DemoVO;

/**
 * @author zhangzhijie
 * 2020/4/24 21:01
 */
public interface DemoService {

    /**
     * 测试接口
     * @param demoDto
     * @return
     */
    DemoVO getTextData(DemoDto demoDto);
}
