package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectJudge;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_judge(判断题)】的数据库操作Service
* @createDate 2024-08-13 17:59:27
*/
public interface SubjectJudgeService extends IService<SubjectJudge> {


    void insert(SubjectJudge subjectJudge);

    List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge);

}
