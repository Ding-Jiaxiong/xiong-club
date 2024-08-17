package com.dingjiaxiong.practice.server.entity.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectPO implements Serializable {

    /**
     * 题目id/主键
     */
    private Long id;

    /**
     * es的文档id
     */
    private Long docId;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 题目难度 DifficultyTypeEnum
     */
    private Integer difficulty;

    /**
     * 出题人erp
     */
    private String setterErp;

    /**
     * 出题人姓名
     */
    private String setterName;

    /**
     * 是否推送
     */
    private Integer isPush;

    /**
     * 题目类型
     */
    private Integer subjectType;

    /**
     * 题目分数
     */
    private Integer subjectScore;

    /**
     * 题目解析
     */
    private String subjectParse;

}