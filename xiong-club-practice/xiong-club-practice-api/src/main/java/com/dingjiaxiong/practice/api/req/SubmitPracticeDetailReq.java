package com.dingjiaxiong.practice.api.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubmitPracticeDetailReq implements Serializable {

    /**
     * 套题id
     */
    private Long setId;

    /**
     * 练习id
     */
    private Long practiceId;

    /**
     * 用时
     */
    private String timeUse;

    /**
     * 交卷时间
     */
    private String submitTime;


}