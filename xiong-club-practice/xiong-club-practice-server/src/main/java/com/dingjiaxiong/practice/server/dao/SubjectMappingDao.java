package com.dingjiaxiong.practice.server.dao;


import com.dingjiaxiong.practice.server.entity.po.LabelCountPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-03 22:17:07
 */
public interface SubjectMappingDao {

    List<LabelCountPO> getLabelSubjectCount(@Param("categoryId") Long categoryId,
                                            @Param("subjectTypeList") List<Integer> subjectTypeList);

}

