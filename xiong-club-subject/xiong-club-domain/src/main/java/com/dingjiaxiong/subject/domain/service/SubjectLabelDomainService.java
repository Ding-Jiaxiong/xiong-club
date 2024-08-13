package com.dingjiaxiong.subject.domain.service;

import com.dingjiaxiong.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * 题目标签领域服务
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/3
 */
public interface SubjectLabelDomainService {

    /**
     * 新增标签
     */
    Boolean add(SubjectLabelBO subjectLabelBO);

    /**
     * 更新标签
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
