package com.dingjiaxiong.subject.domain.service;


import com.dingjiaxiong.subject.domain.entity.SubjectLikedBO;

/**
 * 题目点赞表 领域service
 *
 * @author Ding Jiaxiong
 * @since 2024-08-17 11:42:55
 */
public interface SubjectLikedDomainService {

    /**
     * 添加 题目点赞表 信息
     */
    Boolean add(SubjectLikedBO subjectLikedBO);

    /**
     * 更新 题目点赞表 信息
     */
    Boolean update(SubjectLikedBO subjectLikedBO);

    /**
     * 删除 题目点赞表 信息
     */
    Boolean delete(SubjectLikedBO subjectLikedBO);

}
