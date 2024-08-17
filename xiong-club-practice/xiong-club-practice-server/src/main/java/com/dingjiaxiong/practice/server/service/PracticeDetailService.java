package com.dingjiaxiong.practice.server.service;

import com.dingjiaxiong.practice.api.req.GetScoreDetailReq;
import com.dingjiaxiong.practice.api.req.SubmitPracticeDetailReq;
import com.dingjiaxiong.practice.api.req.SubmitSubjectDetailReq;
import com.dingjiaxiong.practice.api.vo.ScoreDetailVO;

import java.util.List;

public interface PracticeDetailService {

    /**
     * 练习提交题目
     */
    Boolean submitSubject(SubmitSubjectDetailReq req);

    /**
     * 提交练题情况【交卷】
     */
    Boolean submit(SubmitPracticeDetailReq req);

    /**
     * 每题得分详情
     */
    List<ScoreDetailVO> getScoreDetail(GetScoreDetailReq req);


}