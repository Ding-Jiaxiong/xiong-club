package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScoreDetailVO implements Serializable {

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 题目类型
     */
    private Integer subjectType;

    /**
     * 是否正确
     */
    private Integer isCorrect;


}