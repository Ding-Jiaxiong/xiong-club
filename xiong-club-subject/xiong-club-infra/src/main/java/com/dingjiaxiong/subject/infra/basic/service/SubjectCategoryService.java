package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_category(题目分类)】的数据库操作Service
* @createDate 2024-08-12 19:31:07
*/
public interface SubjectCategoryService extends IService<SubjectCategory> {

    /**
     * 查询岗位大类
     */
    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);

}
