package com.dingjiaxiong.subject.domain.convert;

import com.dingjiaxiong.subject.domain.entity.SubjectLikedBO;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectLiked;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 题目点赞表 bo转换器
 *
 * @author Ding Jiaxiong
 * @since 2024-08-17 11:42:55
 */
@Mapper
public interface SubjectLikedBOConverter {

    SubjectLikedBOConverter INSTANCE = Mappers.getMapper(SubjectLikedBOConverter.class);

    SubjectLiked convertBOToEntity(SubjectLikedBO subjectLikedBO);

}
