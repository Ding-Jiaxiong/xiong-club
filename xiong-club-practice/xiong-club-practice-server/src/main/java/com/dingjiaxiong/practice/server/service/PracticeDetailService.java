package com.dingjiaxiong.practice.server.service;

import com.dingjiaxiong.practice.api.req.SubmitPracticeDetailReq;
import com.dingjiaxiong.practice.api.req.SubmitSubjectDetailReq;

public interface PracticeDetailService {


    /**
     * 提交练题情况
     */
    Boolean submit(SubmitPracticeDetailReq req);

}