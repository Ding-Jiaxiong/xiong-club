package com.dingjiaxiong.subject;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 刷题微服务启动类
 *
 * @author: Ding Jiaxiong
 * @date: 2024年8月12日
 */

@SpringBootApplication
@ComponentScan("com.dingjiaxiong")
@MapperScan("com.dingjiaxiong.**.mapper")
public class SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }

}
