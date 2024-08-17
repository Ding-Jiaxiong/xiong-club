package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_info(题目信息表)】的数据库操作Service
 * @createDate 2024-08-13 17:59:27
 */
public interface SubjectInfoService extends IService<SubjectInfo> {

    int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId);

    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize);

    List<SubjectInfo> getContributeCount();

    SubjectInfo queryById(Long id);

}
