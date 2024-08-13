package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectRadio;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectRadioMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_radio(单选题信息表)】的数据库操作Service实现
 * @createDate 2024-08-13 17:59:27
 */
@Service
public class SubjectRadioServiceImpl extends ServiceImpl<SubjectRadioMapper, SubjectRadio>
        implements SubjectRadioService {

    @Resource
    private SubjectRadioMapper subjectRadioMapper;

    @Override
    public void batchInsert(List<SubjectRadio> subjectRadioList) {

        subjectRadioMapper.insertBatch(subjectRadioList);

    }

    @Override
    public List<SubjectRadio> queryByCondition(SubjectRadio subjectRadio) {
        return subjectRadioMapper.queryAllByLimit(subjectRadio);
    }
}




