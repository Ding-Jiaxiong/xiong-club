package com.dingjiaxiong.practice.server.service;

import com.dingjiaxiong.practice.api.vo.SpecialPracticeVO;

import java.util.List;

public interface PracticeSetService {

    /**
     * 获取专项练习内容
     */
    List<SpecialPracticeVO> getSpecialPracticeContent();




}
