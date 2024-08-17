package com.dingjiaxiong.subject.application.convert;

import com.dingjiaxiong.subject.application.dto.SubjectLikedDTO;
import com.dingjiaxiong.subject.domain.entity.SubjectLikedBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 题目点赞表 dto转换器
 *
 * @author Ding Jiaxiong
 * @since 2024-08-17 11:42:55
 */
@Mapper
public interface SubjectLikedDTOConverter {

    SubjectLikedDTOConverter INSTANCE = Mappers.getMapper(SubjectLikedDTOConverter.class);

    SubjectLikedBO convertDTOToBO(SubjectLikedDTO subjectLikedDTO);

}
