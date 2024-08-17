package com.dingjiaxiong.practice.api.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetSubjectDetailReq implements Serializable {

    /**
     * 练习id
     */
    private Long practiceId;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 题目类型
     */
    private Integer subjectType;

}