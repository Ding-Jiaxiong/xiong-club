package com.dingjiaxiong.subject.infra.basic.service;


import com.dingjiaxiong.subject.common.entity.PageResult;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfoEs;

public interface SubjectEsService {

    void createIndex();

    void addDoc();

    void find();

    void search();
}
