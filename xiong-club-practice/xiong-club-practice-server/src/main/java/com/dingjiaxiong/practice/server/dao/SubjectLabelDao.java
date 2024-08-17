package com.dingjiaxiong.practice.server.dao;

import com.dingjiaxiong.practice.server.entity.po.SubjectLabelPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-03 21:50:29
 */
public interface SubjectLabelDao {


    SubjectLabelPO queryById(Long id);

    /**
     * 批量查询当前题目的标签名称
     */
    List<String> getLabelNameByIds(@Param("labelIds") List<Long> labelIds);
}

