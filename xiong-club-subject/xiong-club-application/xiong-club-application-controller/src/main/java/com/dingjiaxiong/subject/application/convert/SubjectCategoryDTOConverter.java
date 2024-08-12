package com.dingjiaxiong.subject.application.convert;

import com.dingjiaxiong.subject.application.dto.SubjectCategoryDTO;
import com.dingjiaxiong.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目分类dto转换器
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/8
 */
@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryDTO);

    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);

    SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO);
}
