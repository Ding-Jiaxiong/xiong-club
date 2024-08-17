package com.dingjiaxiong.practice.server.dao;

import com.dingjiaxiong.practice.server.entity.po.SubjectJudgePO;

public interface SubjectJudgeDao {


    SubjectJudgePO selectBySubjectId(Long repeatSubjectId);


}