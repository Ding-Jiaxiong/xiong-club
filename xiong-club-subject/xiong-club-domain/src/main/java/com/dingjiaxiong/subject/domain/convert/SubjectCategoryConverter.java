package com.dingjiaxiong.subject.domain.convert;

import com.dingjiaxiong.subject.domain.entity.SubjectCategoryBO;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> categoryList);

}
