package com.dingjiaxiong.practice.server.service;

import com.dingjiaxiong.practice.api.req.*;
import com.dingjiaxiong.practice.api.vo.ReportVO;
import com.dingjiaxiong.practice.api.vo.ScoreDetailVO;
import com.dingjiaxiong.practice.api.vo.SubjectDetailVO;

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


    /**
     * 获得答案详情
     */
    SubjectDetailVO getSubjectDetail(GetSubjectDetailReq req);

    /**
     * 答案解析-评估报告
     */
    ReportVO getReport(GetReportReq req);

}