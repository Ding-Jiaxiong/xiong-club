package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SubjectDetailVO implements Serializable {

    /**
     * 正确答案
     */
    private List<Integer> correctAnswer;

    /**
     * 答题者答案
     */
    private List<Integer> respondAnswer;

    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 答案详情
     */
    private List<PracticeSubjectOptionVO> optionList;

    /**
     * 涉及的标签
     */
    private List<String> labelNames;

    /**
     * 题目名称
     */
    private String subjectName;

}