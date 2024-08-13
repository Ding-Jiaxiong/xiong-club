package com.dingjiaxiong.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 题目分类关系表
 *
 * @TableName subject_mapping
 */
@TableName(value = "subject_mapping")
@Data
public class SubjectMapping implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 标签id
     */
    private Long labelId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     *
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}