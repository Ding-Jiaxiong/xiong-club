package com.dingjiaxiong.subject.application.controller;


import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;
import com.dingjiaxiong.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 刷题 Controller
 *
 * @author Ding Jiaxiong
 * @Date 2024年8月12日
 */

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;


    @GetMapping("/test")
    public String test() {

        SubjectCategory subjectCategory = subjectCategoryService.getById(1L);

        System.out.println(subjectCategory);

        return subjectCategory.getCategoryName();
    }

}
