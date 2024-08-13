package com.dingjiaxiong.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMapping;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Mapper
* @createDate 2024-08-13 17:05:16
* @Entity com.dingjiaxiong.subject.infra.basic.entity.SubjectMapping
*/
public interface SubjectMappingMapper extends BaseMapper<SubjectMapping> {

    List<SubjectMapping> queryDistinctLabelId(SubjectMapping subjectMapping);
}




