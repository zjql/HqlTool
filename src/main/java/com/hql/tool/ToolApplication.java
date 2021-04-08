package com.hql.tool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangzhijie
 */

@SpringBootApplication
@MapperScan(basePackages = "com.hql.tool.dto")
public class ToolApplication {


    public static void main(String[] args) {
        SpringApplication.run(ToolApplication.class, args);
    }
}
