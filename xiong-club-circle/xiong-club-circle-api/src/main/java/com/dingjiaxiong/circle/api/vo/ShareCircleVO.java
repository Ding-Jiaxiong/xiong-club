package com.dingjiaxiong.circle.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShareCircleVO implements Serializable {

    /**
     * 圈子ID
     */
    private Long id;

    /**
     * 圈子名称
     */
    private String circleName;

    /**
     * 圈子图标
     */
    private String icon;

    /**
     * 子对象
     */
    private List<ShareCircleVO> children;

}