package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_category(题目分类)】的数据库操作Service实现
* @createDate 2024-08-12 19:31:07
*/
@Service
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory>
    implements SubjectCategoryService {

    @Resource
    private SubjectCategoryMapper subjectCategoryMapper;

    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        return subjectCategoryMapper.queryCategory(subjectCategory);
    }
}




