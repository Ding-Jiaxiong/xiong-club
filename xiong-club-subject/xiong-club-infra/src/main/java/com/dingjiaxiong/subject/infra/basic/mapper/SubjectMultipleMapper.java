package com.dingjiaxiong.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMultiple;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【subject_multiple(多选题信息表)】的数据库操作Mapper
* @createDate 2024-08-13 17:59:27
* @Entity com.dingjiaxiong.subject.infra.basic.entity.SubjectMultiple
*/
public interface SubjectMultipleMapper extends BaseMapper<SubjectMultiple> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectMultiple> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SubjectMultiple> entities);

    List<SubjectMultiple> queryAllByLimit(SubjectMultiple subjectMultiple);

}




