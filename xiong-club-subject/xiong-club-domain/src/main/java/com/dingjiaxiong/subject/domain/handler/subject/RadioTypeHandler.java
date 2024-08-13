package com.dingjiaxiong.subject.domain.handler.subject;

import com.dingjiaxiong.subject.common.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.subject.common.enums.SubjectInfoTypeEnum;
import com.dingjiaxiong.subject.domain.convert.RadioSubjectConverter;
import com.dingjiaxiong.subject.domain.entity.SubjectAnswerBO;
import com.dingjiaxiong.subject.domain.entity.SubjectInfoBO;
import com.dingjiaxiong.subject.domain.entity.SubjectOptionBO;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectRadio;
import com.dingjiaxiong.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目的策略类
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/5
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(Long.valueOf(subjectId));
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
