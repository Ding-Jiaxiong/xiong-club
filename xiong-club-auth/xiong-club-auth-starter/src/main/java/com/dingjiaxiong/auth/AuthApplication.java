package com.dingjiaxiong.auth;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 刷题微服务启动类
 *
 * @author: Ding Jiaxiong
 * @date: 2024年8月12日
 */

@SpringBootApplication
@ComponentScan("com.dingjiaxiong")
@MapperScan("com.dingjiaxiong.**.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

}
