package com.dingjiaxiong.subject.infra.basic.mapper;

import com.dingjiaxiong.subject.infra.basic.entity.SubjectLiked;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 题目点赞表 表数据库访问层
 *
 * @author Ding Jiaxiong
 * @since 2024-08-17 11:42:55
 */
@Repository
public interface SubjectLikedDao extends BaseMapper<SubjectLiked> {

}

