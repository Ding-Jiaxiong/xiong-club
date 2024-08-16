package com.dingjiaxiong.subject.infra.basic.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SubjectInfoEs {

    private Long subjectId;

    private Long docId;

    private String subjectName;

    private String subjectAnswer;

    private String createUser;

    private Long createTime;

    private Integer subjectType;

    private String keyWord;

    private BigDecimal score;

}
