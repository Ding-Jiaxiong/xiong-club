package com.dingjiaxiong.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * oss服务启动器
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/11
 */
@SpringBootApplication
@ComponentScan("com.dingjiaxiong")
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }

}
