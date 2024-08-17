package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PracticeSubjectDetailVO implements Serializable {

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 题目类型
     */
    private Integer subjectType;

    /**
     * 是否回答
     */
    private Integer isAnswer;

}