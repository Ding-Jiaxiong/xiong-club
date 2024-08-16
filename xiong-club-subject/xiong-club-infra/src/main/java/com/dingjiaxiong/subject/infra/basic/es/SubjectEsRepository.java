package com.dingjiaxiong.subject.infra.basic.es;

import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfoEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface SubjectEsRepository extends ElasticsearchRepository<SubjectInfoEs, Long> {


}
