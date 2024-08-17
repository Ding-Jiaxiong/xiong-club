package com.dingjiaxiong.practice.api.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetReportReq implements Serializable {

    /**
     * 练习id
     */
    private Long practiceId;

}