package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PracticeSubjectOptionVO implements Serializable {

    /**
     * 答案类型
     */
    private Integer optionType;

    /**
     * 答案内容
     */
    private String optionContent;

    /**
     * 是否正確
     */
    private Integer isCorrect;

}