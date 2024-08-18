package com.dingjiaxiong.circle.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller启动问题
 *
 * @author: Ding Jiaxiong
 * @date: 2024/3/2
 */
@RestController
@RequestMapping("/circle/")
@Slf4j
public class DemoController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }

}
