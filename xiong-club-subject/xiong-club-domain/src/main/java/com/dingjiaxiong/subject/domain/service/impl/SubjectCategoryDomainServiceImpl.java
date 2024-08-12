package com.dingjiaxiong.subject.domain.service.impl;


import com.dingjiaxiong.subject.domain.convert.SubjectCategoryConverter;
import com.dingjiaxiong.subject.domain.entity.SubjectCategoryBO;
import com.dingjiaxiong.subject.domain.service.SubjectCategoryDomainService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;
import com.dingjiaxiong.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);

        subjectCategoryService.save(subjectCategory);

    }
}
