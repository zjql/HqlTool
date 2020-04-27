package com.hql.tool.controller;

import com.hql.tool.model.Demo;
import com.hql.tool.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhijie
 * 2020/4/24 21:05
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/getTextData")
    public Demo getTextData(@Param("id")int id){
        return demoService.getTextData(id);
    }
}
