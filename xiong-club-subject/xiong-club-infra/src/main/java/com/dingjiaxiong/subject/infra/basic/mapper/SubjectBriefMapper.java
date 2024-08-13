package com.dingjiaxiong.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectBrief;

/**
* @author DingJiaxiong
* @description 针对表【subject_brief(简答题)】的数据库操作Mapper
* @createDate 2024-08-13 17:59:27
* @Entity com.dingjiaxiong.subject.infra.basic.entity.SubjectBrief
*/
public interface SubjectBriefMapper extends BaseMapper<SubjectBrief> {

    SubjectBrief queryAllByLimit(SubjectBrief subjectBrief);

}




