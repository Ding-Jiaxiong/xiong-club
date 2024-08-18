package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnCompletePracticeSetVO implements Serializable {

    /**
     * 套题id
     */
    private Long setId;

    /**
     * 练习id
     */
    private Long practiceId;

    /**
     * 练习时间
     */
    private String practiceTime;

    /**
     * 套题名称
     */
    private String title;

}