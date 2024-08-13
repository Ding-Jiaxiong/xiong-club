package com.dingjiaxiong.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectJudge;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_judge(判断题)】的数据库操作Mapper
* @createDate 2024-08-13 17:59:27
* @Entity com.dingjiaxiong.subject.infra.basic.entity.SubjectJudge
*/
public interface SubjectJudgeMapper extends BaseMapper<SubjectJudge> {

    List<SubjectJudge> queryAllByLimit(SubjectJudge subjectJudge);

}




