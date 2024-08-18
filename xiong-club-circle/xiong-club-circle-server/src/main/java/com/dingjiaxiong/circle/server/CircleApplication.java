package com.dingjiaxiong.circle.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 熊圈微服务启动类
 *
 * @author: Ding Jiaxiong
 * @date: 2024/3/2
 */
@SpringBootApplication
@ComponentScan("com.dingjiaxiong")
@MapperScan("com.dingjiaxiong.**.dao")
@EnableFeignClients(basePackages = "com.dingjiaxiong")
public class CircleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircleApplication.class);
    }

}
