package com.dingjiaxiong.practice.server.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PracticeSetPO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 套题名称
     */
    private String setName;

    /**
     * 1实时生成 2预设套题
     */
    private Integer setType;

    /**
     * 套题热度
     */
    private Integer setHeat;

    /**
     * 套题描述
     */
    private String setDesc;

    /**
     * 大类id
     */
    private Long primaryCategoryId;

    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;

    private Integer isDeleted;
    /**
     * 更新时间
     */
    private Date updateTime;

}