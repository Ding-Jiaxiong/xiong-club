package com.dingjiaxiong.subject.application.controller;

import com.dingjiaxiong.subject.application.convert.SubjectCategoryDTOConverter;
import com.dingjiaxiong.subject.application.dto.SubjectCategoryDTO;
import com.dingjiaxiong.subject.common.entity.Result;
import com.dingjiaxiong.subject.domain.entity.SubjectCategoryBO;
import com.dingjiaxiong.subject.domain.service.SubjectCategoryDomainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 刷题分类controller
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/1
 */

@RestController
@RequestMapping("/subject/category")
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     */
    @PostMapping("/add")

    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {

        System.out.println(subjectCategoryDTO);

        try {

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);

            return Result.ok(true);

        } catch (Exception e) {
            return Result.fail();
        }

    }

}
