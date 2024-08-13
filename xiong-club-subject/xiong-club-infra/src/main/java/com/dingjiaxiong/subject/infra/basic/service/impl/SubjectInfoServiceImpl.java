package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfo;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectInfoMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_info(题目信息表)】的数据库操作Service实现
 * @createDate 2024-08-13 17:59:27
 */
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo>
        implements SubjectInfoService {

    @Resource
    private SubjectInfoMapper subjectInfoMapper;

    @Override
    public int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId) {
        return subjectInfoMapper.countByCondition(subjectInfo, categoryId, labelId);

    }

    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize) {
        return subjectInfoMapper.queryPage(subjectInfo, categoryId, labelId, start, pageSize);
    }
}




