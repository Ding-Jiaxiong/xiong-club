package com.dingjiaxiong.practice.server.service.impl;

import com.dingjiaxiong.practice.api.enums.CompleteStatusEnum;
import com.dingjiaxiong.practice.api.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.practice.api.enums.SubjectInfoTypeEnum;
import com.dingjiaxiong.practice.api.req.GetPracticeSubjectsReq;
import com.dingjiaxiong.practice.api.vo.*;
import com.dingjiaxiong.practice.server.dao.*;
import com.dingjiaxiong.practice.server.entity.dto.CategoryDTO;
import com.dingjiaxiong.practice.server.entity.dto.PracticeSubjectDTO;
import com.dingjiaxiong.practice.server.entity.po.*;
import com.dingjiaxiong.practice.server.service.PracticeSetService;
import com.dingjiaxiong.practice.server.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
@Slf4j
public class PracticeSetServiceImpl implements PracticeSetService {

    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    @Resource
    private SubjectMappingDao subjectMappingDao;

    @Resource
    private SubjectLabelDao subjectLabelDao;

    @Resource
    private PracticeSetDao practiceSetDao;

    @Resource
    private SubjectDao subjectDao;

    @Resource
    private PracticeSetDetailDao practiceSetDetailDao;

    @Resource
    private PracticeDetailDao practiceDetailDao;

    @Resource
    private PracticeDao practiceDao;

    @Resource
    private SubjectRadioDao subjectRadioDao;

    @Resource
    private SubjectMultipleDao subjectMultipleDao;


    @Override
    public List<SpecialPracticeVO> getSpecialPracticeContent() {

        List<SpecialPracticeVO> specialPracticeVOList = new LinkedList<>();

        List<Integer> subjectTypeList = new LinkedList<>();

        subjectTypeList.add(SubjectInfoTypeEnum.RADIO.getCode());
        subjectTypeList.add(SubjectInfoTypeEnum.MULTIPLE.getCode());
        subjectTypeList.add(SubjectInfoTypeEnum.JUDGE.getCode());

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setSubjectTypeList(subjectTypeList);

        List<PrimaryCategoryPO> poList = subjectCategoryDao.getPrimaryCategory(categoryDTO);

        if (CollectionUtils.isEmpty(poList)) {
            return specialPracticeVOList;
        }

        // 组装
        poList.forEach(primaryCategoryPO -> {
            SpecialPracticeVO specialPracticeVO = new SpecialPracticeVO();
            specialPracticeVO.setPrimaryCategoryId(primaryCategoryPO.getParentId());
            CategoryPO categoryPO = subjectCategoryDao.selectById(primaryCategoryPO.getParentId());
            specialPracticeVO.setPrimaryCategoryName(categoryPO.getCategoryName());
            CategoryDTO categoryDTOTemp = new CategoryDTO();
            categoryDTOTemp.setCategoryType(2);
            categoryDTOTemp.setParentId(primaryCategoryPO.getParentId());
            List<CategoryPO> smallPoList = subjectCategoryDao.selectList(categoryDTOTemp);
            if (CollectionUtils.isEmpty(smallPoList)) {
                return;
            }
            List<SpecialPracticeCategoryVO> categoryList = new LinkedList();
            smallPoList.forEach(smallPo -> {
                List<SpecialPracticeLabelVO> labelVOList = getLabelVOList(smallPo.getId(), subjectTypeList);
                if (CollectionUtils.isEmpty(labelVOList)) {
                    return;
                }
                SpecialPracticeCategoryVO specialPracticeCategoryVO = new SpecialPracticeCategoryVO();
                specialPracticeCategoryVO.setCategoryId(smallPo.getId());
                specialPracticeCategoryVO.setCategoryName(smallPo.getCategoryName());
                List<SpecialPracticeLabelVO> labelList = new LinkedList<>();
                labelVOList.forEach(labelVo -> {
                    SpecialPracticeLabelVO specialPracticeLabelVO = new SpecialPracticeLabelVO();
                    specialPracticeLabelVO.setId(labelVo.getId());
                    specialPracticeLabelVO.setAssembleId(labelVo.getAssembleId());
                    specialPracticeLabelVO.setLabelName(labelVo.getLabelName());
                    labelList.add(specialPracticeLabelVO);
                });
                specialPracticeCategoryVO.setLabelList(labelList);
                categoryList.add(specialPracticeCategoryVO);
            });
            specialPracticeVO.setCategoryList(categoryList);
            specialPracticeVOList.add(specialPracticeVO);
        });
        return specialPracticeVOList;


    }

    private List<SpecialPracticeLabelVO> getLabelVOList(Long categoryId, List<Integer> subjectTypeList) {
        List<LabelCountPO> countPOList = subjectMappingDao.getLabelSubjectCount(categoryId, subjectTypeList);
        if (CollectionUtils.isEmpty(countPOList)) {
            return Collections.emptyList();
        }
        List<SpecialPracticeLabelVO> voList = new LinkedList<>();
        countPOList.forEach(countPo -> {
            SpecialPracticeLabelVO vo = new SpecialPracticeLabelVO();
            vo.setId(countPo.getLabelId());
            vo.setAssembleId(categoryId + "-" + countPo.getLabelId());
            SubjectLabelPO subjectLabelPO = subjectLabelDao.queryById(countPo.getLabelId());
            vo.setLabelName(subjectLabelPO.getLabelName());
            voList.add(vo);
        });
        return voList;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PracticeSetVO addPractice(PracticeSubjectDTO dto) {
        PracticeSetVO setVO = new PracticeSetVO();
        List<PracticeSubjectDetailVO> practiceList = getPracticeList(dto);
        if (CollectionUtils.isEmpty(practiceList)) {
            return setVO;
        }
        PracticeSetPO practiceSetPO = new PracticeSetPO();
        practiceSetPO.setSetType(1);
        List<String> assembleIds = dto.getAssembleIds();
        Set<Long> categoryIdSet = new HashSet<>();
        assembleIds.forEach(assembleId -> {
            Long categoryId = Long.valueOf(assembleId.split("-")[0]);
            categoryIdSet.add(categoryId);
        });
        StringBuffer setName = new StringBuffer();
        int i = 1;
        for (Long categoryId : categoryIdSet) {
            if (i > 2) {
                break;
            }
            CategoryPO categoryPO = subjectCategoryDao.selectById(categoryId);
            setName.append(categoryPO.getCategoryName());
            setName.append("、");
            i = i + 1;
        }
        setName.deleteCharAt(setName.length() - 1);
        if (i == 2) {
            setName.append("专项练习");
        } else {
            setName.append("等专项练习");
        }
        practiceSetPO.setSetName(setName.toString());
        String labelId = assembleIds.get(0).split("-")[1];
        SubjectLabelPO labelPO = subjectLabelDao.queryById(Long.valueOf(labelId));
        practiceSetPO.setPrimaryCategoryId(labelPO.getCategoryId());
        practiceSetPO.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        practiceSetPO.setCreatedBy(LoginUtil.getLoginId());
        practiceSetPO.setCreatedTime(new Date());
        practiceSetDao.add(practiceSetPO);
        Long practiceSetId = practiceSetPO.getId();

        //思考，这里哪里不符合规范，配合听视频的延伸
        practiceList.forEach(e -> {
            PracticeSetDetailPO detailPO = new PracticeSetDetailPO();
            detailPO.setSetId(practiceSetId);
            detailPO.setSubjectId(e.getSubjectId());
            detailPO.setSubjectType(e.getSubjectType());
            detailPO.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            detailPO.setCreatedBy(LoginUtil.getLoginId());
            detailPO.setCreatedTime(new Date());
            practiceSetDetailDao.add(detailPO);
        });
        setVO.setSetId(practiceSetId);
        return setVO;
    }


    /**
     * 获取套卷题目信息
     */
    private List<PracticeSubjectDetailVO> getPracticeList(PracticeSubjectDTO dto) {
        List<PracticeSubjectDetailVO> practiceSubjectListVOS = new LinkedList<>();
        //避免重复
        List<Long> excludeSubjectIds = new LinkedList<>();

        //设置题目数量，之后优化到nacos动态配置 【自己设置】
        Integer radioSubjectCount = 1;
        Integer multipleSubjectCount = 1;
        Integer judgeSubjectCount = 1;
        Integer totalSubjectCount = 3;
        //查询单选
        dto.setSubjectCount(radioSubjectCount);
        dto.setSubjectType(SubjectInfoTypeEnum.RADIO.getCode());
        assembleList(dto, practiceSubjectListVOS, excludeSubjectIds);
        //查询多选
        dto.setSubjectCount(multipleSubjectCount);
        dto.setSubjectType(SubjectInfoTypeEnum.MULTIPLE.getCode());
        assembleList(dto, practiceSubjectListVOS, excludeSubjectIds);
        //查询判断
        dto.setSubjectCount(judgeSubjectCount);
        dto.setSubjectType(SubjectInfoTypeEnum.JUDGE.getCode());
        assembleList(dto, practiceSubjectListVOS, excludeSubjectIds);
        //补充题目
        if (practiceSubjectListVOS.size() == totalSubjectCount) {
            return practiceSubjectListVOS;
        }
        Integer remainCount = totalSubjectCount - practiceSubjectListVOS.size();
        dto.setSubjectCount(remainCount);
        dto.setSubjectType(1);
        assembleList(dto, practiceSubjectListVOS, excludeSubjectIds);
        return practiceSubjectListVOS;
    }

    private List<PracticeSubjectDetailVO> assembleList(PracticeSubjectDTO dto, List<PracticeSubjectDetailVO> list, List<Long> excludeSubjectIds) {
        dto.setExcludeSubjectIds(excludeSubjectIds);
        List<SubjectPO> subjectPOList = subjectDao.getPracticeSubject(dto);
        if (CollectionUtils.isEmpty(subjectPOList)) {
            return list;
        }
        subjectPOList.forEach(e -> {
            PracticeSubjectDetailVO vo = new PracticeSubjectDetailVO();
            vo.setSubjectId(e.getId());
            vo.setSubjectType(e.getSubjectType());
            excludeSubjectIds.add(e.getId());
            list.add(vo);
        });
        return list;
    }

    @Override
    public PracticeSubjectListVO getSubjects(GetPracticeSubjectsReq req) {
        Long setId = req.getSetId();
        PracticeSubjectListVO vo = new PracticeSubjectListVO();
        List<PracticeSubjectDetailVO> practiceSubjectListVOS = new LinkedList<>();
        List<PracticeSetDetailPO> practiceSetDetailPOS = practiceSetDetailDao.selectBySetId(setId);
        if (CollectionUtils.isEmpty(practiceSetDetailPOS)) {
            return vo;
        }
        String loginId = LoginUtil.getLoginId();
        Long practiceId = req.getPracticeId();
        practiceSetDetailPOS.forEach(e -> {
            PracticeSubjectDetailVO practiceSubjectListVO = new PracticeSubjectDetailVO();
            practiceSubjectListVO.setSubjectId(e.getSubjectId());
            practiceSubjectListVO.setSubjectType(e.getSubjectType());
            if (Objects.nonNull(practiceId)) {
                PracticeDetailPO practiceDetailPO = practiceDetailDao.selectDetail(practiceId, e.getSubjectId(), loginId);
                if (Objects.nonNull(practiceDetailPO) && StringUtils.isNotBlank(practiceDetailPO.getAnswerContent())) {
                    practiceSubjectListVO.setIsAnswer(1);
                } else {
                    practiceSubjectListVO.setIsAnswer(0);
                }
            }
            practiceSubjectListVOS.add(practiceSubjectListVO);
        });
        vo.setSubjectList(practiceSubjectListVOS);
        PracticeSetPO practiceSetPO = practiceSetDao.selectById(setId);
        vo.setTitle(practiceSetPO.getSetName());
        if (Objects.isNull(practiceId)) {
            Long newPracticeId = insertUnCompletePractice(setId);
            vo.setPracticeId(newPracticeId);
        } else {
            updateUnCompletePractice(practiceId);
            PracticePO practicePO = practiceDao.selectById(practiceId);
            vo.setTimeUse(practicePO.getTimeUse());
            vo.setPracticeId(practiceId);
        }
        return vo;
    }

    private Long insertUnCompletePractice(Long practiceSetId) {
        PracticePO practicePO = new PracticePO();
        practicePO.setSetId(practiceSetId);
        practicePO.setCompleteStatus(CompleteStatusEnum.NO_COMPLETE.getCode());
        practicePO.setTimeUse("00:00:00");
        practicePO.setSubmitTime(new Date());
        practicePO.setCorrectRate(new BigDecimal("0.00"));
        practicePO.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        practicePO.setCreatedBy(LoginUtil.getLoginId());
        practicePO.setCreatedTime(new Date());
        practiceDao.insert(practicePO);
        return practicePO.getId();
    }

    private void updateUnCompletePractice(Long practiceId) {
        PracticePO practicePO = new PracticePO();
        practicePO.setId(practiceId);
        practicePO.setSubmitTime(new Date());
        practiceDao.update(practicePO);
    }


    @Override
    public PracticeSubjectVO getPracticeSubject(PracticeSubjectDTO dto) {
        PracticeSubjectVO practiceSubjectVO = new PracticeSubjectVO();
        SubjectPO subjectPO = subjectDao.selectById(dto.getSubjectId());
        practiceSubjectVO.setSubjectName(subjectPO.getSubjectName());
        practiceSubjectVO.setSubjectType(subjectPO.getSubjectType());
        if (dto.getSubjectType() == SubjectInfoTypeEnum.RADIO.getCode()) {
            List<PracticeSubjectOptionVO> optionList = new LinkedList<>();
            List<SubjectRadioPO> radioSubjectPOS = subjectRadioDao.selectBySubjectId(subjectPO.getId());
            radioSubjectPOS.forEach(e -> {
                PracticeSubjectOptionVO practiceSubjectOptionVO = new PracticeSubjectOptionVO();
                practiceSubjectOptionVO.setOptionContent(e.getOptionContent());
                practiceSubjectOptionVO.setOptionType(e.getOptionType());
                optionList.add(practiceSubjectOptionVO);
            });
            practiceSubjectVO.setOptionList(optionList);
        }
        if (dto.getSubjectType() == SubjectInfoTypeEnum.MULTIPLE.getCode()) {
            List<PracticeSubjectOptionVO> optionList = new LinkedList<>();
            List<SubjectMultiplePO> multipleSubjectPOS = subjectMultipleDao.selectBySubjectId(subjectPO.getId());
            multipleSubjectPOS.forEach(e -> {
                PracticeSubjectOptionVO practiceSubjectOptionVO = new PracticeSubjectOptionVO();
                practiceSubjectOptionVO.setOptionContent(e.getOptionContent());
                practiceSubjectOptionVO.setOptionType(e.getOptionType());
                optionList.add(practiceSubjectOptionVO);
            });
            practiceSubjectVO.setOptionList(optionList);
        }
        return practiceSubjectVO;
    }

}
