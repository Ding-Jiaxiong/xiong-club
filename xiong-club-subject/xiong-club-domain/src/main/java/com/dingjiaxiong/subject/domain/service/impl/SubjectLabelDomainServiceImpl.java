package com.dingjiaxiong.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.dingjiaxiong.subject.common.enums.CategoryTypeEnum;
import com.dingjiaxiong.subject.common.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.subject.domain.convert.SubjectLabelConverter;
import com.dingjiaxiong.subject.domain.entity.SubjectLabelBO;
import com.dingjiaxiong.subject.domain.service.SubjectLabelDomainService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectLabel;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMapping;
import com.dingjiaxiong.subject.infra.basic.service.SubjectCategoryService;
import com.dingjiaxiong.subject.infra.basic.service.SubjectLabelService;
import com.dingjiaxiong.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);

        boolean count = subjectLabelService.save(subjectLabel);
        return count;
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);
        boolean count = subjectLabelService.updateById(subjectLabel);
        return count;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.delete.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);
        boolean count = subjectLabelService.removeById(subjectLabel.getId());
        return count;
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {

        Long categoryId = subjectLabelBO.getCategoryId();

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<SubjectMapping> mappingList = subjectMappingService.queryLableId(subjectMapping);

        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }

        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());

        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBO> boList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });
        return boList;

    }

}
