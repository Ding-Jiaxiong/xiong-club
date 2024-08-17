package com.dingjiaxiong.practice.server.dao;

import com.dingjiaxiong.practice.server.entity.po.PracticeDetailPO;
import com.dingjiaxiong.practice.server.entity.po.PracticeRankPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PracticeDetailDao {

    /**
     * 获取正确答案数量
     */
    int selectCorrectCount(Long practiceId);

    /**
     * 获取得分情况
     */
    List<PracticeDetailPO> selectByPracticeId(Long practiceId);

    /**
     * 插入练题记录
     */
    int insertSingle(PracticeDetailPO practiceDetailPO);

    /**
     * 根据练习id，题目id，查询详情
     */
    PracticeDetailPO selectDetail(@Param("practiceId") Long practiceId,
                                  @Param("subjectId") Long subjectId,
                                  @Param("loginId") String loginId);

    /**
     * 更新练习详情
     */
    int update(PracticeDetailPO practiceDetailPO);

    /**
     * 获取答案情况
     */
    PracticeDetailPO selectAnswer(@Param("practiceId") Long practiceId,@Param("subjectId") Long subjectId);

    /**
     * 获取排行榜情况
     */
    List<PracticeRankPO> getPracticeCount();

    /**
     * 删除练习详情
     */
    int deleteByPracticeId(Long practiceId);

}