package com.dingjiaxiong.practice.server.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SubjectDetailDTO implements Serializable {

    /**
     * 题目id
     */
    private Long id;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 判断题答案
     */
    private Integer isCorrect;

    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 单选、多选、判断题目答案
     */
    private List<SubjectOptionDTO> optionList;


}