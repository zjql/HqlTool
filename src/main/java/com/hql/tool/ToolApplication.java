package com.hql.tool;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhangzhijie
 */

@EnableSwagger2Doc
@SpringBootApplication
public class ToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolApplication.class, args);
    }

}
