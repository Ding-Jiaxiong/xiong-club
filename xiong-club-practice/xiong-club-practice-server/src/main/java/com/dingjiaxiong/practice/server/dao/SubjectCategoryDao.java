package com.dingjiaxiong.practice.server.dao;


import com.dingjiaxiong.practice.server.entity.dto.CategoryDTO;
import com.dingjiaxiong.practice.server.entity.po.CategoryPO;
import com.dingjiaxiong.practice.server.entity.po.PrimaryCategoryPO;

import java.util.List;

/**
 * 题目分类(SubjectCategory)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-01 21:49:58
 */
public interface SubjectCategoryDao {


    List<PrimaryCategoryPO> getPrimaryCategory(CategoryDTO categoryDTO);

    CategoryPO selectById(Long id);


    List<CategoryPO> selectList(CategoryDTO categoryDTOTemp);


}

