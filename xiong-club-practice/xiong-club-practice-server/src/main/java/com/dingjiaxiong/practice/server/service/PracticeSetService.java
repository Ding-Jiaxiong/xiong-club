package com.dingjiaxiong.practice.server.service;

import com.dingjiaxiong.practice.api.common.PageResult;
import com.dingjiaxiong.practice.api.req.GetPracticeSubjectsReq;
import com.dingjiaxiong.practice.api.req.GetUnCompletePracticeReq;
import com.dingjiaxiong.practice.api.vo.*;
import com.dingjiaxiong.practice.server.entity.dto.PracticeSetDTO;
import com.dingjiaxiong.practice.server.entity.dto.PracticeSubjectDTO;

import java.util.List;

public interface PracticeSetService {

    /**
     * 获取专项练习内容
     */
    List<SpecialPracticeVO> getSpecialPracticeContent();


    /**
     * 开始练习
     */
    PracticeSetVO addPractice(PracticeSubjectDTO dto);

    /**
     * 获取练习题
     */
    PracticeSubjectListVO getSubjects(GetPracticeSubjectsReq req);

    /**
     * 获取题目
     */
    PracticeSubjectVO getPracticeSubject(PracticeSubjectDTO dto);

    /**
     * 获取模拟套题内容
     */
    PageResult<PracticeSetVO> getPreSetContent(PracticeSetDTO dto);

    /**
     * 获取未完成练习内容
     */
    PageResult<UnCompletePracticeSetVO> getUnCompletePractice(GetUnCompletePracticeReq req);
}
