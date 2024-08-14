package com.dingjiaxiong.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_label(题目标签表)】的数据库操作Mapper
* @createDate 2024-08-13 16:43:44
* @Entity com.dingjiaxiong.subject.infra.basic.entity.SubjectLabel
*/
public interface SubjectLabelMapper extends BaseMapper<SubjectLabel> {

    List<SubjectLabel> batchQueryById(List<Long> labelIdList);

    List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel);

}




