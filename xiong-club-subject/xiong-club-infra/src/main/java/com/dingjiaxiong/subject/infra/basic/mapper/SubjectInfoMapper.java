package com.dingjiaxiong.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【subject_info(题目信息表)】的数据库操作Mapper
 * @createDate 2024-08-13 17:59:27
 * @Entity com.dingjiaxiong.subject.infra.basic.entity.SubjectInfo
 */
public interface SubjectInfoMapper extends BaseMapper<SubjectInfo> {

    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,
                         @Param("categoryId") Long categoryId,
                         @Param("labelId") Long labelId);

    List<SubjectInfo> queryPage(@Param("subjectInfo") SubjectInfo subjectInfo,
                                @Param("categoryId") Long categoryId,
                                @Param("labelId") Long labelId,
                                @Param("start") int start,
                                @Param("pageSize") Integer pageSize);

    List<SubjectInfo> getContributeCount();


}




