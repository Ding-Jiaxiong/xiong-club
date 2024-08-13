package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectRadio;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_radio(单选题信息表)】的数据库操作Service
* @createDate 2024-08-13 17:59:27
*/
public interface SubjectRadioService extends IService<SubjectRadio> {

    /**
     * 批量插入
     * @param subjectRadioList
     */
    void batchInsert(List<SubjectRadio> subjectRadioList);

    /*
       查询
     */
    List<SubjectRadio> queryByCondition(SubjectRadio subjectRadio);

}
