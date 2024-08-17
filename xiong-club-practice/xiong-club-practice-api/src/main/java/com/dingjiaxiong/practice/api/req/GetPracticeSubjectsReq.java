package com.dingjiaxiong.practice.api.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetPracticeSubjectsReq implements Serializable {

    /**
     * 套题id
     */
    private Long setId;

    /**
     * 练习id
     */
    private Long practiceId;

}