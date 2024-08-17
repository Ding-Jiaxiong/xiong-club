package com.dingjiaxiong.practice.server.service;

import com.dingjiaxiong.practice.api.req.GetPracticeSubjectsReq;
import com.dingjiaxiong.practice.api.vo.PracticeSetVO;
import com.dingjiaxiong.practice.api.vo.PracticeSubjectListVO;
import com.dingjiaxiong.practice.api.vo.SpecialPracticeVO;
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
}
