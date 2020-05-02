package com.hql.tool.service.Impl;

import com.github.pagehelper.PageHelper;
import com.hql.tool.config.utils.ListPageUtil;
import com.hql.tool.config.utils.page.PageInfos;
import com.hql.tool.config.utils.page.PageUtil;
import com.hql.tool.dto.DemoDto;
import com.hql.tool.mapper.DemoMapper;
import com.hql.tool.service.DemoService;
import com.hql.tool.vo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageInfos<DemoVO> getTextData(DemoDto dto) {
        PageHelper.startPage(PageUtil.getPageNum(dto),PageUtil.getPageSize(dto));
        List<DemoVO> queryList = demoMapper.getCreateDateTime(dto);
       return PageUtil.convertPageObj(DemoVO.class,queryList);

    }

    @Override
    public ListPageUtil<DemoVO> getTextPageData(DemoDto demoDto) {
        return ListPageUtil.startPage(demoMapper.getCreateDateTime(demoDto),PageUtil.getPageNum(demoDto),PageUtil.getPageSize(demoDto));
    }
}
