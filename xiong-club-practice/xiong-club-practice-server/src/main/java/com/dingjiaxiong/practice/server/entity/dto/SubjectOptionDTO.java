package com.dingjiaxiong.practice.server.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectOptionDTO implements Serializable {

    /**
     * 答案类型
     */
    private Integer optionType;

    /**
     * 答案内容
     */
    private String optionContent;

    /**
     * 是否为正确答案
     */
    private Integer isCorrect;

}