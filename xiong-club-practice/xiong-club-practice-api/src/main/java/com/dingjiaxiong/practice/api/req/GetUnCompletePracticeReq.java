package com.dingjiaxiong.practice.api.req;

import com.dingjiaxiong.practice.api.common.PageInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetUnCompletePracticeReq implements Serializable {

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

}