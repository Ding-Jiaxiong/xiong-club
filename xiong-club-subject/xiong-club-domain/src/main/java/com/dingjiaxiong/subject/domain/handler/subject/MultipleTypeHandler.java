package com.dingjiaxiong.subject.domain.handler.subject;

import com.dingjiaxiong.subject.common.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.subject.common.enums.SubjectInfoTypeEnum;
import com.dingjiaxiong.subject.domain.convert.MultipleSubjectConverter;
import com.dingjiaxiong.subject.domain.entity.SubjectAnswerBO;
import com.dingjiaxiong.subject.domain.entity.SubjectInfoBO;
import com.dingjiaxiong.subject.domain.entity.SubjectOptionBO;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMultiple;
import com.dingjiaxiong.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 * 
 * @author: Ding Jiaxiong
 * @date: 2023/10/5
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //多选题目的插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(Long.valueOf(subjectId));
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOList = MultipleSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
