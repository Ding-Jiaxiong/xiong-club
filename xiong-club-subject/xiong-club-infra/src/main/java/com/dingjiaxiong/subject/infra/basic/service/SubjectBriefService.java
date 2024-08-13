package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectBrief;

/**
* @author DingJiaxiong
* @description 针对表【subject_brief(简答题)】的数据库操作Service
* @createDate 2024-08-13 17:59:27
*/
public interface SubjectBriefService extends IService<SubjectBrief> {

    void insert(SubjectBrief subjectBrief);

    SubjectBrief queryByCondition(SubjectBrief subjectBrief);

}
