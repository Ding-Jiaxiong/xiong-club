package com.dingjiaxiong.subject.infra.basic.service;


import com.dingjiaxiong.subject.common.entity.PageResult;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfoEs;

public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);

}
