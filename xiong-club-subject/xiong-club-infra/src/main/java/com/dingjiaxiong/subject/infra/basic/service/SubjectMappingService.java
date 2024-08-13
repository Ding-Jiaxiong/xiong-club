package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMapping;

import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service
 * @createDate 2024-08-13 17:05:16
 */
public interface SubjectMappingService extends IService<SubjectMapping> {

    /**
     * 查询标签 id
     *
     * @param subjectMapping
     * @return
     */
    List<SubjectMapping> queryLableId(SubjectMapping subjectMapping);

    /**
     * 批量插入
     */
    void batchInsert(List<SubjectMapping> mappingList);

}
