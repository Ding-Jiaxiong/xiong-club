package com.dingjiaxiong.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMapping;
import com.dingjiaxiong.subject.infra.basic.mapper.SubjectMappingMapper;
import com.dingjiaxiong.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service实现
 * @createDate 2024-08-13 17:05:16
 */
@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping>
        implements SubjectMappingService {

    @Resource
    private SubjectMappingMapper subjectMappingMapper;

    @Override
    public List<SubjectMapping> queryLableId(SubjectMapping subjectMapping) {

        return subjectMappingMapper.queryDistinctLabelId(subjectMapping);
    }

    @Override
    public void batchInsert(List<SubjectMapping> mappingList) {

        subjectMappingMapper.insertBatch(mappingList);

    }
}




