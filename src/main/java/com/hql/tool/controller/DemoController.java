package com.hql.tool.controller;

import com.hql.tool.config.annotation.Syslog;
import com.hql.tool.config.msg.BaseResponse;
import com.hql.tool.config.msg.ResponseMsgUtil;
import com.hql.tool.config.utils.page.PageInfos;
import com.hql.tool.dto.DemoDto;
import com.hql.tool.service.DemoService;
import com.hql.tool.vo.DemoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhijie
 * 2020/4/24 21:05
 * 测试控制层
 */
@Slf4j
@RestController
@RequestMapping(value = "/demo",produces = "application/json")
@Api(tags = "DemoController",description = "测试接口")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Syslog(description = "测试接口数据")
    @PostMapping("/getTextData")
    @ApiOperation(value = "测试接口",notes = "测试接口")
    public BaseResponse<PageInfos<DemoVO>> getTextData(@RequestBody DemoDto demoDto){
        return ResponseMsgUtil.success(demoService.getTextData(demoDto));
    }
}
