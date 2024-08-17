package com.dingjiaxiong.practice.server.dao;

import com.dingjiaxiong.practice.server.entity.dto.PracticeSetDTO;
import com.dingjiaxiong.practice.server.entity.po.PracticeSetPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PracticeSetDao {

    /**
     * 新增套题
     */
    int add(PracticeSetPO po);

    PracticeSetPO selectById(Long setId);

    int updateHeat(Long setId);

    /**
     * 获取模拟考卷列表数量
     */
    Integer getListCount(PracticeSetDTO dto);

    /**
     * 获取模拟考卷列表
     */
    List<PracticeSetPO> getSetList(@Param("dto") PracticeSetDTO dto,
                                   @Param("limit") int limit,
                                   @Param("offset") int offset);

}
