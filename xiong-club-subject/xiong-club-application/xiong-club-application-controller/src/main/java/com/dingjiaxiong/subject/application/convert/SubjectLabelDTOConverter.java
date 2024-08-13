package com.dingjiaxiong.subject.application.convert;

import com.dingjiaxiong.subject.application.dto.SubjectLabelDTO;
import com.dingjiaxiong.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto的转换
 * 
 * @author: Ding Jiaxiong
 * @date: 2023/10/3
 */
@Mapper
public interface SubjectLabelDTOConverter {

    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBOToLabelDTOList(List<SubjectLabelBO> boList);

}
