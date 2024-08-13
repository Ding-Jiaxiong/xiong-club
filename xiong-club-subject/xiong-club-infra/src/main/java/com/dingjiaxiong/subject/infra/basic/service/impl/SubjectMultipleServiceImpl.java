package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMultiple;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectMultipleMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_multiple(多选题信息表)】的数据库操作Service实现
 * @createDate 2024-08-13 17:59:27
 */
@Service
public class SubjectMultipleServiceImpl extends ServiceImpl<SubjectMultipleMapper, SubjectMultiple>
        implements SubjectMultipleService {

    @Resource
    private SubjectMultipleMapper subjectMultipleMapper;

    @Override
    public void batchInsert(List<SubjectMultiple> subjectMultipleList) {

        subjectMultipleMapper.insertBatch(subjectMultipleList);

    }

    @Override
    public List<SubjectMultiple> queryByCondition(SubjectMultiple subjectMultiple) {
        return subjectMultipleMapper.queryAllByLimit(subjectMultiple);
    }
}




