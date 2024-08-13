package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectJudge;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectJudgeMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_judge(判断题)】的数据库操作Service实现
 * @createDate 2024-08-13 17:59:27
 */
@Service
public class SubjectJudgeServiceImpl extends ServiceImpl<SubjectJudgeMapper, SubjectJudge>
        implements SubjectJudgeService {

    @Resource
    private SubjectJudgeMapper subjectJudgeMapper;

    @Override
    public void insert(SubjectJudge subjectJudge) {
        subjectJudgeMapper.insert(subjectJudge);
    }

    @Override
    public List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge) {
        return subjectJudgeMapper.queryAllByLimit(subjectJudge);
    }
}




