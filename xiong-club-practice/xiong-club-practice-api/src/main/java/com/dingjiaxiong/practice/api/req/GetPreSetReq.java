package com.dingjiaxiong.practice.api.req;

import com.dingjiaxiong.practice.api.common.PageInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetPreSetReq implements Serializable {

    /**
     * 排序类型 0默认 1最新 2最热
     */
    private Integer orderType;

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

    /**
     * 套题名称
     */
    private String setName;

}