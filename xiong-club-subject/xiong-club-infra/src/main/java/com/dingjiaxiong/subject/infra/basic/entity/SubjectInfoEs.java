package com.dingjiaxiong.subject.infra.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "subject_index", createIndex = false)
public class SubjectInfoEs {

    @Field(type = FieldType.Long)
    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String subjectName;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String subjectAnswer;

    @Field(type = FieldType.Keyword)
    private String createUser;

    @Field(type = FieldType.Date, index = false)
    private Date createTime;

}
