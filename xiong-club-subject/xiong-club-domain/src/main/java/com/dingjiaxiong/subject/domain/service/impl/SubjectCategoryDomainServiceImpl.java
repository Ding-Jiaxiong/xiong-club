package com.dingjiaxiong.subject.domain.service.impl;


import com.alibaba.fastjson.JSON;
import com.dingjiaxiong.subject.common.enums.CategoryTypeEnum;
import com.dingjiaxiong.subject.common.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.subject.domain.convert.SubjectCategoryConverter;
import com.dingjiaxiong.subject.domain.entity.SubjectCategoryBO;
import com.dingjiaxiong.subject.domain.entity.SubjectLabelBO;
import com.dingjiaxiong.subject.domain.service.SubjectCategoryDomainService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectLabel;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMapping;
import com.dingjiaxiong.subject.infra.basic.service.SubjectCategoryService;
import com.dingjiaxiong.subject.infra.basic.service.SubjectLabelService;
import com.dingjiaxiong.subject.infra.basic.service.SubjectMappingService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private ThreadPoolExecutor labelThreadPool;

    private Cache<String, String> localCache =
            CacheBuilder.newBuilder()
                    .maximumSize(5000)
                    .expireAfterWrite(10, TimeUnit.SECONDS)
                    .build();

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);

        subjectCategoryService.save(subjectCategory);

    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);

        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}",
                    JSON.toJSONString(boList));
        }

        boList.forEach(bo -> {
            Integer subjectCount = subjectCategoryService.querySubjectCount(bo.getId());
            bo.setCount(subjectCount);
        });

        return boList;

    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        boolean count = subjectCategoryService.updateById(subjectCategory);
        return count;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        boolean count = subjectCategoryService.removeById(subjectCategory.getId());
        return count;
    }

    @SneakyThrows
    @Override
    public List<SubjectCategoryBO> queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO) {

        String cacheKey = "CategoryAndLabel." + subjectCategoryBO.getId();
        String content = localCache.getIfPresent(cacheKey);

        List<SubjectCategoryBO> subjectCategoryBOS = new LinkedList<>();

        if (StringUtils.isBlank(content)) {  // 缓存拿的时候为空
            // 为空就去查
            subjectCategoryBOS = getSubjectCategoryBOS(subjectCategoryBO.getId());

            // 查完放入缓存
            localCache.put(cacheKey, JSON.toJSONString(subjectCategoryBOS));
        } else {
            // 缓存不为空, 就解析缓存拿到的东西
            subjectCategoryBOS = JSON.parseArray(content, SubjectCategoryBO.class);
        }

        // 查询当前大类下所有分类
        return subjectCategoryBOS;
    }

    private List<SubjectCategoryBO> getSubjectCategoryBOS(Long categoryId) {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(categoryId);

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryCategoryAndLabel.subjectCategoryList:{}",
                    JSON.toJSONString(subjectCategoryList));
        }
        List<SubjectCategoryBO> categoryBOList = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);


        Map<Long, List<SubjectLabelBO>> map = new HashMap<>();
        List<CompletableFuture<Map<Long, List<SubjectLabelBO>>>> completableFutureList = categoryBOList.stream().map(category ->
                CompletableFuture.supplyAsync(() -> getLabelBOList(category), labelThreadPool)
        ).collect(Collectors.toList());

        completableFutureList.forEach(future -> {

            try {
                Map<Long, List<SubjectLabelBO>> resultMap = future.get();

                if (!CollectionUtils.isEmpty(resultMap)) {
                    map.putAll(resultMap);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

//
//        // 一次获取标签信息
//        List<FutureTask<Map<Long, List<SubjectLabelBO>>>> futureTaskList = new LinkedList<>();
//
//        // 线程池并发调用
//        Map<Long, List<SubjectLabelBO>> map = new HashMap<>();
//
//        categoryBOList.forEach(category -> {
//
//            FutureTask<Map<Long, List<SubjectLabelBO>>> futureTask = new FutureTask<>(() ->
//                    getLabelBOList(category));
//
//            futureTaskList.add(futureTask);
//            labelThreadPool.submit(futureTask);
//        });
//
//        for (FutureTask<Map<Long, List<SubjectLabelBO>>> futureTask : futureTaskList) {
//            Map<Long, List<SubjectLabelBO>> resultMap = futureTask.get();
//
//            if (CollectionUtils.isEmpty(resultMap)) {
//                continue;
//            }
//
//            map.putAll(resultMap);
//        }

        categoryBOList.forEach(categoryBO -> {
            categoryBO.setLabelBOList(map.get(categoryBO.getId()));
        });

        return categoryBOList;
    }

    private Map<Long, List<SubjectLabelBO>> getLabelBOList(SubjectCategoryBO category) {

        if (log.isInfoEnabled()) {
            log.info("getLabelBOList:{}", JSON.toJSONString(category));
        }

        Map<Long, List<SubjectLabelBO>> labelMap = new HashMap<>();

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(category.getId());

        List<SubjectMapping> mappingList = subjectMappingService.queryLableId(subjectMapping);

        if (CollectionUtils.isEmpty(mappingList)) {
            return null;
        }

        List<Long> LabelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());

        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(LabelIdList);

        List<SubjectLabelBO> labelBOList = new LinkedList<>();

        labelList.forEach(label -> {
            SubjectLabelBO subjectLabelBO = new SubjectLabelBO();
            subjectLabelBO.setId(label.getId());
            subjectLabelBO.setLabelName(label.getLabelName());
            subjectLabelBO.setCategoryId(label.getCategoryId());
            subjectLabelBO.setSortNum(label.getSortNum());

            labelBOList.add(subjectLabelBO);
        });

        labelMap.put(category.getId(), labelBOList);

        return labelMap;
    }

}
