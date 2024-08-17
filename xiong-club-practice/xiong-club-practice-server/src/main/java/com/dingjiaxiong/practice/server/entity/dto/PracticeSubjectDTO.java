package com.dingjiaxiong.practice.server.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PracticeSubjectDTO implements Serializable {

    /**
     * 分类与标签组合的ids
     */
    private List<String> assembleIds;

    /**
     * 题目类型
     */
    private Integer subjectType;

    /**
     * 题目数量
     */
    private Integer subjectCount;

    /**
     * 要排除的题目id
     */
    private List<Long> excludeSubjectIds;

    /**
     * 题目类型
     */
    private Long subjectId;


}