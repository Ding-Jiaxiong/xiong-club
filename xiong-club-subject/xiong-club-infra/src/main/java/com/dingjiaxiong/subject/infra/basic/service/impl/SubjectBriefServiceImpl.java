package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectBrief;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectBriefMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_brief(简答题)】的数据库操作Service实现
 * @createDate 2024-08-13 17:59:27
 */
@Service
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefMapper, SubjectBrief>
        implements SubjectBriefService {

    @Resource
    private SubjectBriefMapper subjectBriefMapper;

    @Override
    public void insert(SubjectBrief subjectBrief) {
        subjectBriefMapper.insert(subjectBrief);
    }

    @Override
    public SubjectBrief queryByCondition(SubjectBrief subjectBrief) {
        return subjectBriefMapper.queryAllByLimit(subjectBrief);
    }
}




