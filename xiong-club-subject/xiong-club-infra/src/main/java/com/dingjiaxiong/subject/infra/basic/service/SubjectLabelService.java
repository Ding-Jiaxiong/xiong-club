package com.dingjiaxiong.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_label(题目标签表)】的数据库操作Service
* @createDate 2024-08-13 16:43:44
*/
public interface SubjectLabelService extends IService<SubjectLabel> {

    List<SubjectLabel> batchQueryById(List<Long> labelIdList);

}
