package com.dingjiaxiong.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.dingjiaxiong.subject.common.entity.PageResult;
import com.dingjiaxiong.subject.common.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.subject.common.util.IdWorkerUtil;
import com.dingjiaxiong.subject.domain.convert.SubjectInfoConverter;
import com.dingjiaxiong.subject.domain.entity.SubjectInfoBO;
import com.dingjiaxiong.subject.domain.entity.SubjectOptionBO;
import com.dingjiaxiong.subject.domain.handler.subject.SubjectTypeHandler;
import com.dingjiaxiong.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.dingjiaxiong.subject.domain.service.SubjectInfoDomainService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfo;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfoEs;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectLabel;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMapping;
import com.dingjiaxiong.subject.infra.basic.service.SubjectEsService;
import com.dingjiaxiong.subject.infra.basic.service.SubjectInfoService;
import com.dingjiaxiong.subject.infra.basic.service.SubjectLabelService;
import com.dingjiaxiong.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectEsService subjectEsService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }

        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        subjectInfoService.save(subjectInfo);

        Long id = subjectInfo.getId();

        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());

        subjectInfoBO.setId(id);
        handler.add(subjectInfoBO);

        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                mappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(mappingList);

        //同步到es
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setDocId(new IdWorkerUtil(1, 1, 1).nextId());
        subjectInfoEs.setSubjectId(subjectInfo.getId());
        subjectInfoEs.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        subjectInfoEs.setCreateTime(new Date().getTime());
        subjectInfoEs.setCreateUser("Ding Jiaxiong");
        subjectInfoEs.setSubjectName(subjectInfo.getSubjectName());
        subjectInfoEs.setSubjectType(subjectInfo.getSubjectType());
        subjectEsService.insert(subjectInfoEs);


    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {

        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId()
                , subjectInfoBO.getLabelId());
        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBO.getCategoryId()
                , subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOS = SubjectInfoConverter.INSTANCE.convertListInfoToBO(subjectInfoList);
        subjectInfoBOS.forEach(info -> {
            SubjectMapping subjectMapping = new SubjectMapping();
            subjectMapping.setSubjectId(info.getId());
            List<SubjectMapping> mappingList = subjectMappingService.queryLableId(subjectMapping);
            List<Long> labelIds = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
            List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIds);
            List<String> labelNames = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
            info.setLabelName(labelNames);
        });
        pageResult.setRecords(subjectInfoBOS);
        pageResult.setTotal(count);
        return pageResult;

    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoService.getById(subjectInfoBO.getId());
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());
        SubjectInfoBO bo = SubjectInfoConverter.INSTANCE.convertOptionAndInfoToBo(optionBO, subjectInfo);
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLableId(subjectMapping);
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelName(labelNameList);

        return bo;
    }

    @Override
    public PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBO subjectInfoBO) {
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setPageNo(subjectInfoBO.getPageNo());
        subjectInfoEs.setPageSize(subjectInfoBO.getPageSize());
        subjectInfoEs.setKeyWord(subjectInfoBO.getKeyWord());
        return subjectEsService.querySubjectList(subjectInfoEs);
    }
}
