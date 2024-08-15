package com.dingjiaxiong.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_category(题目分类)】的数据库操作Mapper
* @createDate 2024-08-12 19:31:07
* @Entity generator.domain.SubjectCategory
*/
public interface SubjectCategoryMapper extends BaseMapper<SubjectCategory> {

    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);

    Integer querySubjectCount(Long id);

}




