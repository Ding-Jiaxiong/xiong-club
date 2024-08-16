package com.dingjiaxiong.subject.application.controller;

import com.dingjiaxiong.subject.infra.basic.service.SubjectEsService;
import com.dingjiaxiong.subject.infra.entity.UserInfo;
import com.dingjiaxiong.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试 rpc 调用
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/1
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class TestFeignController {

    @Resource
    private UserRpc userRpc;

    @Resource
    private SubjectEsService subjectEsService;

    @GetMapping("testFeign")
    public void testFeign() {
        UserInfo userInfo = userRpc.getUserInfo("oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4");
        log.info("testFeign.userInfo:{}", userInfo);
    }

    @GetMapping("testCreateIndex")
    public void testCreateIndex() {

        subjectEsService.createIndex();
    }

    @GetMapping("addDocs")
    public void addDocs() {

        subjectEsService.addDoc();
    }

    @GetMapping("find")
    public void find() {

        subjectEsService.find();
    }

    @GetMapping("search")
    public void search() {

        subjectEsService.search();
    }


}
