package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectLabel;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectLabelMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_label(题目标签表)】的数据库操作Service实现
* @createDate 2024-08-13 16:43:44
*/
@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel>
    implements SubjectLabelService {

    @Resource
    private SubjectLabelMapper subjectLabelMapper;

    @Override
    public List<SubjectLabel> batchQueryById(List<Long> labelIdList) {

        return subjectLabelMapper.batchQueryById(labelIdList);

    }
}




