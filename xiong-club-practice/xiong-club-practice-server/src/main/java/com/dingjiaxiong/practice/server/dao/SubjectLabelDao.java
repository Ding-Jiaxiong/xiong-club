package com.dingjiaxiong.practice.server.dao;

import com.dingjiaxiong.practice.server.entity.po.SubjectLabelPO;

/**
 * 题目标签表(SubjectLabel)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-03 21:50:29
 */
public interface SubjectLabelDao {


    SubjectLabelPO queryById(Long id);

}

