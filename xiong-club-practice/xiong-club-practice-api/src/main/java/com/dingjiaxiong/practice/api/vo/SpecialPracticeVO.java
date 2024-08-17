package com.dingjiaxiong.practice.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SpecialPracticeVO implements Serializable {

    private String primaryCategoryName;

    private Long primaryCategoryId;

    private List<SpecialPracticeCategoryVO> categoryList;

}
