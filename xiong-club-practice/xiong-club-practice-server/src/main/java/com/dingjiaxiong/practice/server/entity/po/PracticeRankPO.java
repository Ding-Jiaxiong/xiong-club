package com.dingjiaxiong.practice.server.entity.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class PracticeRankPO implements Serializable {

    /**
     * 练习数量
     */
    private Integer count;

    /**
     * 创建人
     */
    private String createdBy;

}