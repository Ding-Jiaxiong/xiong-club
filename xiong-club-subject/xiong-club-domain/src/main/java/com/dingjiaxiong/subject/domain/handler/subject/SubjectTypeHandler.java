package com.dingjiaxiong.subject.domain.handler.subject;


import com.dingjiaxiong.subject.common.enums.SubjectInfoTypeEnum;
import com.dingjiaxiong.subject.domain.entity.SubjectInfoBO;
import com.dingjiaxiong.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 题目查询
     * @param i
     * @return
     */
    SubjectOptionBO query(int i);

}
