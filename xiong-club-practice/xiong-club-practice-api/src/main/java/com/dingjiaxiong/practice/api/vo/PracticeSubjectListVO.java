package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PracticeSubjectListVO implements Serializable {

    /**
     * 练习标题
     */
    private String title;

    /**
     * 题目列表
     */
    private List<PracticeSubjectDetailVO> subjectList;

    /**
     * 练习id
     */
    private Long practiceId;

    /**
     * 用时
     */
    private String timeUse;

}