package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RankVO implements Serializable {

    /**
     * 头像
     */
    private String avatar;

    /**
     * 名称
     */
    private String name;

    /**
     * 练习数量
     */
    private Integer count;


}