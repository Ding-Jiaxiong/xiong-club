package com.dingjiaxiong.practice.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 练习微服务启动类
 *
 * @author: Ding Jiaxiong
 * @date: 2024/3/2
 */
@SpringBootApplication
@ComponentScan("com.dingjiaxiong")
@MapperScan("com.dingjiaxiong.**.dao")
public class PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class);
    }

}
