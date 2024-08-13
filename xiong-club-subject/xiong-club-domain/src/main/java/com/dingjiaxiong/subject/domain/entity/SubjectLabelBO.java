package com.dingjiaxiong.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签bo
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/3
 */
@Data
public class SubjectLabelBO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标签分类
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 分类id
     */
    private Long categoryId;

}

