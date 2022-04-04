package com.aliyun.springboottrue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @Author MengXX
 * @Decription:启动类
 * @Date 2022/3/2  14:46
 */
@SpringBootApplication
@CrossOrigin//跨服务
@MapperScan("com.aliyun.springboottrue.dao")
public class SpringBootTrueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTrueApplication.class, args);
    }

}
