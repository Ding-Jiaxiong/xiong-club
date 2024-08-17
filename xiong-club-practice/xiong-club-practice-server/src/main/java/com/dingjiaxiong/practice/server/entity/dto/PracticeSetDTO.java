package com.dingjiaxiong.practice.server.entity.dto;

import com.dingjiaxiong.practice.api.common.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PracticeSetDTO implements Serializable {

    /**
     * 排除的套题id
     */
    private List<Long> excludeSetId;

    /**
     * 套题类型
     */
    private Integer setType;

    /**
     * 大类id
     */
    private Long primaryCategoryId;

    /**
     * 数量
     */
    private Integer limitCount;

    /**
     * 排序类型 1默认 2最新 3最热
     */
    private Integer orderType;

    /**
     * 套题名称
     */
    private String setName;

    /**
     * 分页信息
     */
    private PageInfo pageInfo;



}