package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMultiple;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_multiple(多选题信息表)】的数据库操作Service
* @createDate 2024-08-13 17:59:27
*/
public interface SubjectMultipleService extends IService<SubjectMultiple> {

    void batchInsert(List<SubjectMultiple> subjectMultipleList);

    List<SubjectMultiple> queryByCondition(SubjectMultiple subjectMultiple);

}
